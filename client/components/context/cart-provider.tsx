"use client";

import { createContext, useContext, useEffect, useState } from "react";

type ShippingCartProviderProps = {
  children: React.ReactNode;
};

type CartItem = {
  id: number;
  count: number;
};

type ShoppingCartContext = {
  isOpen: boolean;
  openCart: () => void;
  closeCart: () => void;
  getItemQuantity: (id: number) => number;
  increaseCartQuantity: (id: number, name: string) => void;
  increaseCartManyQuantities: (
    id: number,
    count: number,
  ) => void;
  decreaseCartQuantity: (id: number) => void;
  removeFromCart: (id: number) => void;
  cartQuantity: number;
  cartItems: CartItem[];
};
const ShoppingCartContext = createContext({} as ShoppingCartContext);

export function useShoppingCart() {
  return useContext(ShoppingCartContext);
}

export function ShoppingCartProvider({ children }: ShippingCartProviderProps) {
  const [isOpen, setIsOpen] = useState(false);
  const [cartItems, setCartItems] = useState<CartItem[]>([]);

  const cartQuantity = cartItems.reduce(
    (quantity, item) => quantity + item.count,
    0
  );

  const openCart = () => {
    setIsOpen(true);
  };

  const closeCart = () => {
    setIsOpen(false);
  };

  function getItemQuantity(id: number) {
    return cartItems.find((item) => item.id === id)?.count || 0;
  }

  function increaseCartQuantity(id: number, name: string) {
    setCartItems((currItems) => {
      if (currItems.find((item) => item.id === id) == null) {
        return [...currItems, { id, name, count: 1 }];
      } else {
        return currItems.map((item) => {
          if (item.id === id) {
            return { ...item, name, count: item.count + 1 };
          } else {
            return item;
          }
        });
      }
    });
  }

  function increaseCartManyQuantities(
    id: number,
    count: number,
  ) {
    setCartItems((currItems) => {
      if (currItems.find((item) => item.id === id) == null) {
        return [...currItems, { id, count: count }];
      } else {
        return currItems.map((item) => {
          if (item.id === id) {
            return { ...item, count: item.count + count };
          } else {
            return item;
          }
        });
      }
    });
  }

  useEffect(() => {
    console.log("cartItems: ", cartItems);
  }, [cartItems]);

  function decreaseCartQuantity(id: number) {
    setCartItems((currItems) => {
      if (currItems.find((item) => item.id == id)?.count === 1) {
        return currItems.filter((item) => item.id !== id);
      } else {
        return currItems.map((item) => {
          if (item.id === id) {
            return { ...item, quantity: item.count - 1 };
          } else {
            return item;
          }
        });
      }
    });
  }

  function removeFromCart(id: number) {
    setCartItems((currItems) => currItems.filter((item) => item.id !== id));
  }

  return (
    <ShoppingCartContext.Provider
      value={{
        isOpen,
        getItemQuantity,
        increaseCartQuantity,
        increaseCartManyQuantities,
        decreaseCartQuantity,
        removeFromCart,
        openCart,
        closeCart,
        cartItems,
        cartQuantity,
      }}
    >
      {children}
    </ShoppingCartContext.Provider>
  );
}
