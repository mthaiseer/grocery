# grocery

This document details about online store, user shopping, checkout, discount and bill generation 

# Functional requirement 

Customer can login to online store 
Customer select new cart
Customer add or remove Products to cart
Customer proceed to checkout 
Store calculate discount and generate invoice 
Customer make payment 
Customer select logout 

# Assumptions 
database and related operations are out-of-scope
UI components are out-of-scope
payment and proceeding are out-of-scope
session management is out of scope 


# User stories 
As a user, I want to login to store, so I can be a member  
As a member, I want to  add or remove Items to my cart 
As a member, I want to checkout, so discount will be applied and generate bill 

# Key classes
1. Shop - holds both customer and checkout process
2. Customer - base class holds customer 
3. CustomeBuilder - create Affiliate/Member/Employee, also assign percentage discount 
4. OnlineGroceryAllTest - all test cases

#How to run 
1. clone 


