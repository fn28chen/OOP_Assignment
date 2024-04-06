import React, { useEffect, useState } from "react";
import { Sheet } from "../ui/sheet";
import Image from "next/image";
import axios from "axios";
import { Button } from "../ui/button";
import { useShoppingCart } from "../context/cart-provider";

type CartItemProp = {
  id: number;
  quantity: number;
};

type Item = {
  id: number;
  name: string;
  price: number;
  image: string;
};

export function CartItem({ id, quantity }: CartItemProp) {
  const [item, setItem] = useState<Item | null>(null);
  const { removeFromCart } = useShoppingCart();

  useEffect(() => {
    const fetchItem = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/api/item/get/${id}`
        );
        setItem(response.data);
      } catch (error) {
        console.error("Error fetching item:", error);
      }
    };
    fetchItem();
  });
  if (item == null) return null;
  return (
    <Sheet>
      <div className="flex flex-row justify-center items-center gap-4 py-2">
        <Image
          alt={item.name}
          src={item.image}
          width={`75`}
          height={`75`}
          objectFit="cover"
        />
        <div className="flex flex-row">
          <span>
            {item.name}{" "}
            {quantity > 1 && (
              <span className="" style={{ fontSize: ".65rem" }}>
                x{quantity}
              </span>
            )}
          </span>
          <span>{item.price * quantity}</span>
        </div>
        <Button
          variant="destructive"
          size="sm"
          className="ml-auto"
          onClick={() => removeFromCart(id)}
        >
          &times;
        </Button>
      </div>
    </Sheet>
  );
}
