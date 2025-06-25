class abc:
    def __init__(self,cat,price,qty):
        self.cat = cat
        self.price=price
        self.qty=qty
    def add_to_cart(self, item,number,quant):
        self.cat.append(item)
        self.price.append(number)
        self.qty.append(quant)
        print(f"Added {item} to cart.")

    def remove_from_cart(self, item,number,quant):
            self.cart.remove(item)
            self.cart.remove(number)
            self.cart.remove(quant)
            print(f"Removed {item} from cart.")

    def view_cart(self):
            for item in self.cat:
                print(f" - {item}")
product=abc([],[],[])
p1=["Biscuit"]
p2=[25]
p3=[10]
while True:
     print("1:adding element")
     print("2:removing element")
     print("3:search")
     n=int(input("choose number"))
     if n==1:
          product.add_to_cart(p1,p2,p3)

     elif n==2:
          product.remove_from_cart(p1,p2,p3)
     elif n==3:
          product.view_cart(p1)
     else:
          break
