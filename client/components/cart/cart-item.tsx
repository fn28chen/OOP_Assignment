import { useState, useEffect } from "react";
import axios from "axios";
import { Button } from "@/components/ui/button";
import { useShoppingCart } from "../context/cart-provider";
import { Sheet } from "../ui/sheet";
import Image from "next/image";

type CartItemProps = {
  id: number;
  count: number;
};

type Item = {
  id: number;
  name: string;
  price: number;
  image: string;
};

export function CartItem({ id, count }: CartItemProps) {
  const { removeFromCart } = useShoppingCart();
  const [item, setItem] = useState<Item | null>(null);

  useEffect(() => {
    const fetchItem = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/api/item/get/item/${id}`
        );
        setItem(response.data);
      } catch (error) {
        console.error("Error fetching item:", error);
      }
    };

    fetchItem();
  }, [id]);

  const handleRemoveFromCart = () => {
    removeFromCart(id);
    axios.delete(`http://localhost:8080/api/cart/delete/item/${id}`)
    .then(response => {
      console.log(response.data);
    })
    .catch(error => {
      console.error('Error removing item from cart:', error);
    });
    localStorage.removeItem("cart");
  }

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
          <div className="">
            <div>
              {item.name}{" "}
              {count > 1 && (
                <span className="" style={{ fontSize: ".65rem" }}>
                  x{count}
                </span>
              )}
            </div>
            <div> {item.price * count}</div>
          </div>
        </div>
        <Button
          variant="destructive"
          size="sm"
          onClick={() => handleRemoveFromCart()}
          className="ml-auto"
        >
          &times;
        </Button>
      </div>
    </Sheet>
  );
}
