# grocery

This document details about online store, user shopping, checkout, discount and bill generation 

# Functional requirement 

1.Customer can login to online store 

2.Customer select new cart

3.Customer add or remove Products to cart

4.Customer proceed to checkout 

5.Store calculate discount and generate invoice 


# Assumptions 
1.database and related operations are out-of-scope

2.UI components are out-of-scope

3.payment and proceeding are out-of-scope

4.session management is out of scope 



# User stories 
As a user, I want to login to store, so I can be a member  

As a member, I want to  add or remove Items to my cart 

As a member, I want to checkout, so discount will be applied and generate bill 


# Key classes
1. Shop - holds both customer and checkout process
2. Customer - base class holds customer 
3. CustomeBuilder - create Affiliate/Member/Employee, also assign percentage discount 
4. OnlineGroceryAllTest - all test cases

# How to run 
1. clone  https://github.com/mthaiseer/grocery.git
2. Run ShopNowTest.java as test case

# use case and class diagram are found here
https://github.com/mthaiseer/grocery/blob/master/onlineshop/Online%20Grocery%20System.docx




