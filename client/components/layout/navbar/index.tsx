
"use client";
import react from "react";
import Link from "next/link";
import { useRouter } from "next/navigation";
import dynamic from "next/dynamic";

import { Button } from "@/components/ui/button";
import { FaRegUser } from "react-icons/fa";
import { RiShoppingCartLine } from "react-icons/ri";

import { ModeToggle } from "@/components/global/toggle-theme";

const menu: { title: string; href: string; description: string }[] = [
  {
    title: "Category 1",
    href: "/search/1",
    description:
      "A modal dialog that interrupts the user with important content and expects a response.",
  },
  {
    title: "Category 2",
    href: "/search/2",
    description:
      "A modal dialog that interrupts the user with important content and expects a response.",
  },
  {
    title: "Category 3",
    href: "/search/3",
    description:
      "A modal dialog that interrupts the user with important content and expects a response.",
  },
  {
    title: "Category 4",
    href: "/search/4",
    description:
      "A modal dialog that interrupts the user with important content and expects a response.",
  },
  {
    title: "Category 5",
    href: "/search/5",
    description:
      "A modal dialog that interrupts the user with important content and expects a response.",
  },
  {
    title: "Category 6",
    href: "/search/6",
    description:
      "A modal dialog that interrupts the user with important content and expects a response.",
  },
  {
    title: "Category 7",
    href: "/search/7",
    description:
      "A modal dialog that interrupts the user with important content and expects a response.",
  },
  {
    title: "Category 8",
    href: "/search/8",
    description:
      "A modal dialog that interrupts the user with important content and expects a response.",
  },
  {
    title: "Category 9",
    href: "/search/9",
    description:
      "A modal dialog that interrupts the user with important content and expects a response.",
  },
  {
    title: "Accessories",
    href: "/search/10",
    description:
      "A modal dialog that interrupts the user with important content and expects a response.",
  },
];

export default function Navbar() {
  const router = useRouter();

  return (
    <nav className="relative flex items-center justify-between p-4 lg:px-6">
      <div className="block flex-none md:hidden"></div>
      <div className="flex w-full items-center">
        <div className="flex w-full md:w-1/3">
          <Link
            href="/"
            className="mr-2 flex w-full items-center justify-center md:w-auto lg:mr-6"
          >
            <div className="ml-2 flex-none text-sm font-medium uppercase md:hidden lg:block">
              Logo
            </div>
          </Link>
        </div>
        <div className="hidden justify-center md:flex md:w-1/3">
          <Link
            href="/"
            className="md:hidden mr-2 flex w-full items-center justify-center md:w-auto lg:mr-6"
          >
            Clothes Shop
          </Link>
        </div>

        <div className="flex items-center justify-end md:w-1/3 gap-2">
          <ModeToggle />
          <Link href="/auth/login">
            <Button variant="outline" size="custom">
              <FaRegUser />
            </Button>
          </Link>
          <Button variant="outline" size="custom">
            <RiShoppingCartLine />
          </Button>
        </div>
      </div>
    </nav>
  );
}
