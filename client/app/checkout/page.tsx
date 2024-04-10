"use client";
import axios, { AxiosResponse } from "axios";
import Image from "next/image";
import { useEffect, useState } from "react";
import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { LargeNumberLike } from "crypto";
import { useRouter } from "next/navigation";

interface CartItem {
  id: number;
  name: string;
  image: string;
  count: number;
  price: number;
}

interface ApiResponse {
  id: number;
  name: string;
  image: string;
  price: number;
}

const CheckoutPage = () => {
  const [cartItems, setCartItems] = useState<CartItem[]>([]);
  const router = useRouter();

  useEffect(() => {
    const storedCartItems = localStorage.getItem("cart");
    if (storedCartItems) {
      const parsedCartItems: CartItem[] = JSON.parse(storedCartItems);
      Promise.all(
        parsedCartItems.map((item) =>
          axios.get<ApiResponse>(
            `http://localhost:8080/api/item/get/item/${item.id}`
          )
        )
      ).then((responses: AxiosResponse<ApiResponse>[]) => {
        const fullCartItems: CartItem[] = responses.map((response, index) => ({
          id: response.data.id,
          name: response.data.name,
          image: response.data.image,
          count: parsedCartItems[index].count,
          price: response.data.price,
        }));
        setCartItems(fullCartItems);
      });
    }
  }, []);

  const handleSubmitDeal = () => {
    const storedCartItems = localStorage.getItem("cart");
    const parsedCartItems = JSON.parse(storedCartItems || "[]");
    const totalPrice = cartItems.reduce(
      (acc, item) => acc + item.price * item.count,
      0
    );

    const userDTO = {
      id: 1,
    };

    const cartDTO = {
      id: 1,
      userDTO,
    };

    // Post cart items ( NOT DONE )
    axios
      .post("http://localhost:8080/api/cart/add/items", {
        id: 1,
        userDTO,
        itemDTOS: parsedCartItems.map((item: CartItem) => ({
          id: item.id,
          count: item.count,
        })),
      })
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.error("Error adding items to cart:", error);
      });

    // Post total price ( DONE )
    axios
      .post("http://localhost:8080/api/bill/create/bill", {
        totalPrice,
        cartDTO: cartDTO,
        itemDTOS: parsedCartItems,
      })
      .then((response) => {
        console.log(response.data);
        // Clear the cart after successful checkout
        localStorage.removeItem("cart");
      })
      .catch((error) => {
        console.error("Error creating bill:", error);
      });

      // router.push("/");
      
  };

  return (
    <div className="flex flex-col px-32 py-4 w-full h-full">
      <h1>Checkout Page</h1>
      <ul className="items-center justify-start mb-4">
        {cartItems.map((item, index) => (
          <li key={index} className="mt-4">
            <Card className="flex flex-row max-w-[400px]">
              <CardHeader>
                <Image
                  alt={item.name}
                  src={item.image}
                  width={`100`}
                  height={`100`}
                  objectFit="cover"
                />
              </CardHeader>
              <CardContent className="py-4 items-center justify-center">
                <CardTitle>{item.name}</CardTitle>
                <CardDescription>Quantity: {item.count}</CardDescription>
                <CardDescription>Price: {item.price}</CardDescription>
                <CardDescription>
                  Total: {item.count * item.price}
                </CardDescription>
              </CardContent>
            </Card>
          </li>
        ))}
      </ul>
      <div>
        Total price:{" "}
        {cartItems.reduce((acc, item) => acc + item.price * item.count, 0)}
      </div>
      <Button
        variant="default"
        onClick={handleSubmitDeal}
        className="flex justify-end items-center mt-4 ml-auto"
      >
        Submit Order
      </Button>
    </div>
  );
};

export default CheckoutPage;
