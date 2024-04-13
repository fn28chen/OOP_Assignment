"use client";
import { UserContext } from "@/components/context/user-provider";
import { User as UserIcon } from "lucide-react";
import React, { useContext } from "react";
import {
  Card,
  CardTitle,
  CardDescription,
  CardHeader,
  CardContent,
} from "@/components/ui/card";

const ProfilePage = () => {
  const { user } = useContext(UserContext);

  console.log(user);

  return (
    <div>
      <Card>
        <CardHeader>
          <UserIcon size={48} />
        </CardHeader>
        <CardContent>
          <CardTitle>{user?.fullName}</CardTitle>
          <CardDescription>Email: {user?.email}</CardDescription>
        </CardContent>
      </Card>
    </div>
  );
};

export default ProfilePage;