Feature: search an checkout for product
	@placeOrder
	Scenario Outline: Product added to cart is same as searched
		Given User is on GreenCart Landing Page
		When User searched with shortname <Name> and extracted actual name of product
		And add "3" items of selected product to cart
		Then User proceeds to checkout and validates the <Name> in checkout page
		And Verify user has ability to enter promocode and place the order
		
		Examples:
		| Name |
		| Tom  |
	