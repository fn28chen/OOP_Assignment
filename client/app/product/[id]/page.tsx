"use client";
import Image from "next/image";
import Link from "next/link";
import { useParams, useRouter } from "next/navigation";
import React, { useEffect, useState } from "react";

import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { Button } from "@/components/ui/button";
import { useShoppingCart } from "@/components/context/cart-provider";
import axios from "axios";
interface Product {
  id: number;
  name: string;
  image: string;
  price: number;
  count: number;
  category: {
    id: number;
    name: string;
  };
}

const Product = () => {
  const { id } = useParams<{ id: string }>();
  const [product, setProduct] = useState<Product | null>(null);
  const [localQuantity, setLocalQuantity] = useState(0);
  const router = useRouter();
  const {
    getItemQuantity,
    increaseCartManyQuantities,
  } = useShoppingCart();
  const quantity = getItemQuantity(Number(id));

  const handleIncreaseLocalQuantity = () => {
    setLocalQuantity(localQuantity + 1);
  };

  const handleDecreaseLocalQuantity = () => {
    setLocalQuantity(localQuantity - 1);
  };

  const handleSubmitCart = () => {
    increaseCartManyQuantities(Number(id), localQuantity);
    setLocalQuantity(0);

    const newCartItem: { id: number; count: number } = {
      id: Number(id),
      count: localQuantity,
    };

    localStorage.setItem("cart", JSON.stringify(newCartItem));
    setLocalQuantity(0);

    axios
    .post("http://localhost:8080/api/cart/add/items", {
      id: 1, // id cart
      itemDTOS: [
        {
          id: Number(id),
          count: localQuantity,
        },
      ],
    })
    .then((response) => {
      console.log(response.data);
      setLocalQuantity(0);
    })
    .catch((error) => {
      console.error("Error adding items to cart:", error);
    });

  };

  const removeLocalQuantity = () => {
    setLocalQuantity(0);
  };

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch(
          `http://localhost:8080/api/item/get/item/${id}`
        );
        const data = await response.json();
        setProduct(data);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };

    if (id) {
      fetchData();
    }
  }, [id]);

  // console.log(product);

  return (
    <div className="flex items-center justify-center">
      {product && (
        <Card className="w-[800px] m-4 items-center justify-center">
          <CardHeader className="flex flex-row gap-4">
            <Button
              variant="default"
              onClick={() => {
                router.push("/");
              }}
            >
              {`<-`}
            </Button>
            <CardTitle>{product.name}</CardTitle>
          </CardHeader>
          <CardContent className="flex flex-row justify-start px-4 pb-4 gap-4">
            <CardContent>
              <div className="flex items-center justify-center">
                <Image
                  src={product.image}
                  alt={product.name}
                  width={200}
                  height={200}
                />
              </div>
            </CardContent>
            <CardContent className="">
              <CardContent>
                <p className="text-[20px] border-spacing-1">{product.name}</p>
                <p className="text-[20px] border-spacing-1">{product.price}$</p>
                <p className="text-[20px] border-spacing-1">
                  Product in stock: {product.count}
                </p>
              </CardContent>
              {localQuantity === 0 ? (
                <CardContent className="flex items-center justify-start">
                  <Button
                    variant="default"
                    onClick={() => handleIncreaseLocalQuantity()}
                  >
                    Add To Cart
                  </Button>
                </CardContent>
              ) : (
                <div className="flex flex-col justify-start">
                  <CardContent className="flex justify-start">
                    <Button
                      variant="default"
                      onClick={() => handleIncreaseLocalQuantity()}
                      disabled={localQuantity >= product.count}
                    >
                      +
                    </Button>
                    <Label className="m-4">{localQuantity}</Label>
                    <Button
                      variant="default"
                      onClick={() => handleDecreaseLocalQuantity()}
                      disabled={localQuantity <= 0}
                    >
                      -
                    </Button>
                  </CardContent>
                  <CardContent className={`flex flex-row justify-start gap-4`}>
                    <Button
                      variant="default"
                      onClick={() => handleSubmitCart()}
                      className="w-[80px]"
                    >
                      Submit
                    </Button>
                    <Button
                      variant="default"
                      onClick={() => removeLocalQuantity()}
                      className="w-[80px]"
                    >
                      Remove
                    </Button>
                  </CardContent>
                </div>
              )}
            </CardContent>
          </CardContent>
        </Card>
      )}
    </div>
  );
};

export default Product;
