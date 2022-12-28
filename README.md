# NewAgeShopping
Flow of program
> Go to package com.test.main and execute program.
> there will be four option displayed with additional details
> we will get input from user accourdingly.
> first option is for guest user who only want to see product list. DisplayList class will handle it.
> as per requirement user must register to buy product so StoreUserDetails class will get registration info from user.
> then user must create userid and password UserLoginCredentials class will handle it
> program which verify the credentials VerifyExistingUserCredentials class handle it.
> after successful verification the user will able to buy products using userid AddProductsToCart class which register its purchase.
> FinalCartData class display the purchase of user and total amount
> Then Admin Registartion for login crendentials
> Admin commands have different features like get all registered user and list purchase history of user 
> get total sold quantity of product by using product id all these done by com.admin package.
