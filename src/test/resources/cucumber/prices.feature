Feature: Price, based on a date of a product,
  will return the resulted amount and additional information for a specific price.

  Scenario Outline: Price <price>, based on date <date> and <productId> product and <brandId> brand
    Given A price with date <date>
	When I check the product <productId> and brand <brandId>
	Then The system returns the price <price>
	And The system returns priceList <priceList>
	
	Examples:
	
	| date                  | productId | brandId 	  | price | priceList  |
	| '2020-06-14 17:00:00' | 35455     | 1           | 25.45 | 2          |
	| '2020-11-29 00:00:00' | 35455     | 1           | 38.95 | 4          |