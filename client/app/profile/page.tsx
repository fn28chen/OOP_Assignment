"use client";
import { UserContext } from "@/components/context/user-provider";
import { User as UserIcon } from "lucide-react";
import React, { useContext, useEffect, useState } from "react";
import {
  Card,
  CardTitle,
  CardDescription,
  CardHeader,
  CardContent,
} from "@/components/ui/card";
import axios from "axios";

interface User {
  id: number;
  fullName: string;
  email: string;
}

const ProfilePage = () => {
  const { user } = useContext(UserContext);
  const [userInfo, setUserInfo] = useState<User | null>(null);

  useEffect(() => {
    axios.post("http://localhost:8080/api/user/get/user/email", {
      email: user?.email,
      fullName: user?.fullName,
    })
    .then(response => {
      setUserInfo(response.data);
    })
    .catch(error => {
      console.error('Error fetching user info:', error);
    });
  }, []);
  

  return (
    <div>
      <Card>
        <CardHeader>
          <UserIcon size={48} />
        </CardHeader>
        <CardContent>
          <CardTitle>{userInfo?.id}</CardTitle>
          <CardTitle>{user?.fullName}</CardTitle>
          <CardDescription>Email: {user?.email}</CardDescription>
        </CardContent>
      </Card>
    </div>
  );
};

export default ProfilePage;