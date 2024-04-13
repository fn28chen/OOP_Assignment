"use client";
import { zodResolver } from "@hookform/resolvers/zod";
import { useForm } from "react-hook-form";
import { z } from "zod";

import { Button } from "@/components/ui/button";
import {
  Form,
  FormControl,
  FormDescription,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "@/components/ui/form";
import { Input } from "@/components/ui/input";
import Link from "next/link";
import { usePathname, useRouter } from "next/navigation";
import { useContext, useEffect, useState } from "react";
import { UserContext } from "@/components/context/user-provider";
import axios from "axios";
import { useToast } from "@/components/ui/use-toast";

const formSchema = z.object({
  email: z.string().email({
    message: "Please enter a valid email.",
  }),
  password: z.string().min(8, {
    message: "Password must be at least 8 characters.",
  }),
});


export default function ProfileForm() {
  const { setUser } = useContext(UserContext);
  const router = useRouter();
  const { toast } = useToast();

  const form = useForm<z.infer<typeof formSchema>>({
    resolver: zodResolver(formSchema),
  });

  async function onSubmit(values: z.infer<typeof formSchema>) {
    try {
      const response = await fetch("http://localhost:8080/api/user/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(values),
      });

      if (response.ok) {
        const data = await response.json();
        console.log("Login successful", data);
        const userInfo = await axios.post("http://localhost:8080/api/user/get/user/email", {
          email: data.email,
          fullName: data.fullName,
        });

        // console.log(userInfo.data);

        localStorage.setItem("user", JSON.stringify(userInfo.data));
        // console.log(localStorage.getItem("user"));
        setUser(data);
        
        console.log(data);
      } else {
        const errorData = await response.json();
        console.error("Login failed", errorData);
      }

      toast({
        title: "Login successfully!",
        description: "You're login successfully!",
      });
    } catch (error) {
      console.error("An error occurred while logging in", error);
      toast({
        title: "Login failed!",
        description: "!!!",
      });
    }
  }

  const handleSubmit = () => {
    router.push("/");
  }
  
  return (
    <section className="flex items-center justify-center min-h-screen">
      <Form {...form}>
        <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-4">
          <FormField
            control={form.control}
            name="email"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Email</FormLabel>
                <FormControl>
                  <Input
                    type="email"
                    placeholder="shadcn"
                    value={field.value || ""}
                    onChange={field.onChange}
                  />
                </FormControl>
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="password"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Password</FormLabel>
                <FormControl>
                  <Input
                    type="password"
                    placeholder="shadcn"
                    value={field.value || ""}
                    onChange={field.onChange}
                  />
                </FormControl>
              </FormItem>
            )}
          />
          <div className="flex flex-col gap-4">
            <Button type="submit" onClick={handleSubmit}>Submit</Button>
            <Link href="/auth/register">
              <div className="flex flex-row justify-center items-center">
                <p>Don't have an account?</p>
                <Button variant="link">
                  <p className=" text-blue-600">Register</p>
                </Button>
              </div>
            </Link>
          </div>
        </form>
      </Form>
    </section>
  );
}
