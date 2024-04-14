"use client";
import { UserContext } from "@/components/context/user-provider";
import { User as UserIcon } from "lucide-react";
import React, { useContext, useEffect, useState } from "react";
import axios from "axios";
import { LoadingPage } from "@/components/global/loading";
import Image from "next/image";

import {
  Card,
  CardTitle,
  CardDescription,
  CardHeader,
  CardContent,
} from "@/components/ui/card";

import {
  Table,
  TableBody,
  TableCaption,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";

interface User {
  id: number;
  name: string;
  email: string;
}

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

const ProfilePage = () => {
  const { user } = useContext(UserContext);
  const [userInfo, setUserInfo] = useState<User | null>(null);
  const [listItems, setListItems] = useState<Product[]>([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    axios
      .post("http://localhost:8080/api/user/get/user/email", {
        email: user?.email,
        fullName: user?.fullName,
      })
      .then((response) => {
        setUserInfo(response.data);
        return axios.post("http://localhost:8080/api/user/get/all/item", {
          id: response.data.id,
        });
      })
      .then((response) => {
        setListItems(response.data);
        console.log("List Item Bought: ", response.data);
        setIsLoading(false);
      })
      .catch((error) => {
        console.error("Error fetching user info:", error);
        setIsLoading(false);
      });
  }, []);

  if (isLoading) {
    return <LoadingPage />;
  }

  return (
    <div className="flex flex-col px-8">
      <Card className="flex flex-row w-1/3">
        <CardHeader>
          <UserIcon size={48} />
        </CardHeader>
        <CardContent className="mt-4 items-center justify-center">
          <CardTitle>{userInfo?.name}</CardTitle>
          <CardDescription>Email: {userInfo?.email}</CardDescription>
        </CardContent>
      </Card>
      <Table>
        <TableHeader>
          <TableRow>
            <TableHead className="w-[200px]">Image</TableHead>
            <TableHead className="w-[200px]">Name</TableHead>
            <TableHead className="w-[200px]">Price</TableHead>
            <TableHead className="w-[200px]">Count</TableHead>
            <TableHead className="w-[200px]">Category</TableHead>
          </TableRow>
        </TableHeader>
        <TableBody>
          {listItems.map((item, index) => (
            <TableRow>
              <TableCell className="w-[200px]">
                <Image
                  src={item.image}
                  alt={item.name}
                  width={50}
                  height={50}
                />
              </TableCell>
              <TableCell className="w-[200px]">{item.name}</TableCell>
              <TableCell className="w-[200px]">{item.price}</TableCell>
              <TableCell className="w-[200px]">{item.count}</TableCell>
              <TableCell className="w-[200px]">{item.category.name}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </div>
  );
};

export default ProfilePage;
