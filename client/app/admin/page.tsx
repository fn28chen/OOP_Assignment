import Link from "next/link"
import { Button } from "@/components/ui/button"
import { DropdownMenuTrigger, DropdownMenuLabel, DropdownMenuSeparator, DropdownMenuItem, DropdownMenuContent, DropdownMenu } from "@/components/ui/dropdown-menu"
import { CardTitle, CardDescription, CardHeader, CardContent, Card } from "@/components/ui/card"
import Image from "next/image"

export default function AdminPage() {
  return (
    <div className="grid min-h-screen w-full lg:grid-cols-[280px_1fr]">
      <div className="hidden border-r bg-gray-100/40 lg:block dark:bg-gray-800/40">
        <div className="flex h-full max-h-screen flex-col gap-2">
          <div className="flex h-[60px] items-center border-b px-6">
            <Link className="flex items-center gap-2 font-semibold" href="#">
              <span className="">Clothes Shop
</span>
            </Link>
            <Button className="ml-auto h-8 w-8" size="icon" variant="outline">
              <span className="sr-only">Toggle notifications</span>
            </Button>
          </div>
          <div className="flex-1 overflow-auto py-2">
            <nav className="grid items-start px-4 text-sm font-medium">
              <Link
                className="flex items-center gap-3 rounded-lg px-3 py-2 text-gray-500 transition-all hover:text-gray-900 dark:text-gray-400 dark:hover:text-gray-50"
                href="/admin/order"
              >
                Orders
              </Link>
              <Link
                className="flex items-center gap-3 rounded-lg px-3 py-2 text-gray-500 transition-all hover:text-gray-900 dark:text-gray-400 dark:hover:text-gray-50"
                href="/admin/product"
              >
                Products
              </Link>
              <Link
                className="flex items-center gap-3 rounded-lg px-3 py-2 text-gray-500 transition-all hover:text-gray-900 dark:text-gray-400 dark:hover:text-gray-50"
                href="/admin/customers"
              >
                Customers
              </Link>
            </nav>
          </div>
        </div>
      </div>
      <div className="flex flex-col">
        <header className="flex h-14 lg:h-[60px] items-center gap-4 border-b bg-gray-100/40 px-6 dark:bg-gray-800/40">
          <Link className="lg:hidden" href="#">
            <span className="sr-only">Home</span>
          </Link>
          <div className="flex-1">
            <h1 className="font-semibold text-lg">Dashboard</h1>
          </div>
          <DropdownMenu>
            <DropdownMenuTrigger asChild>
              <Button
                className="rounded-full border border-gray-200 w-8 h-8 dark:border-gray-800"
                size="icon"
                variant="ghost"
              >
                <Image
                  alt="Avatar"
                  className="rounded-full"
                  height="32"
                  src="/placeholder.svg"
                  style={{
                    aspectRatio: "32/32",
                    objectFit: "cover",
                  }}
                  width="32"
                />
              </Button>
            </DropdownMenuTrigger>
          </DropdownMenu>
        </header>
        <main className="flex flex-1 flex-col gap-4 p-4 md:gap-8 md:p-6">
          <div className="grid gap-4 md:grid-cols-2 lg:grid-cols-4">
            <Card>
              <CardHeader>
                <CardTitle>Total Sales</CardTitle>
                <CardDescription>Monthly total sales</CardDescription>
              </CardHeader>
              <CardContent>
                <p className="text-3xl font-semibold mx-4 my-2 mt-auto">$0</p>
              </CardContent>
            </Card>
            <Card>
              <CardHeader>
                <CardTitle>Orders</CardTitle>
                <CardDescription>Number of orders</CardDescription>
              </CardHeader>
              <CardContent>
                <p className="text-3xl font-semibold mx-4 my-2 mt-auto">0</p>
              </CardContent>
            </Card>
            <Card>
              <CardHeader>
                <CardTitle>Customers</CardTitle>
                <CardDescription>Number of customers</CardDescription>
              </CardHeader>
              <CardContent>
                <p className="text-3xl font-semibold mx-4 my-2 mt-auto">0</p>
              </CardContent>
            </Card>
            <Card>
              <CardHeader>
                <CardTitle>Products</CardTitle>
                <CardDescription>Number of products</CardDescription>
              </CardHeader>
              <CardContent>
                <p className="text-3xl font-semibold mx-4 my-2 mt-auto">0</p>
              </CardContent>
            </Card>
          </div>
        </main>
      </div>
    </div>
  )
}

