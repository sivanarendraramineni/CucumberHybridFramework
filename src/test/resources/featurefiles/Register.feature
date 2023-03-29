Feature: Registration functionality

Scenario: User create account with only mandatory fields
Given user navigate to registration page
When user enter the details into fields 
| firstname				|			siva		|
|secondname			|			narendra			|
|email					|		sivanarendra.ramineni@gmail.com				|
|telephone			|		1234567890				|
|password			  |	123456					|
|confirmpassword|	123456					|
And user selects privacy policy
And user clicks on continue button
Then user account created successfully

Scenario: User create account with all fields
Given user navigate to registration page
When user enter the details into fields 
| firstname				|			siva		|
|secondname			|			narendra			|
|email					|		sivanarendra.r@gmail.com				|
|telephone			|		1234567890				|
|password			  |	1234567				|
|confirmpassword|	1234567				|
And user selects yes for newletter
And user selects privacy policy
And user clicks on continue button
Then user account created successfully

Scenario: User create duplicate account
Given user navigate to registration page
When user enter the details into fields 
| firstname				|			siva		|
|secondname			|			narendra			|
|email					|		sivanarendra.r@gmail.com				|
|telephone			|		1234567890				|
|password			  |	12345					|
|confirmpassword|	12345					|
And user selects privacy policy
And user clicks on continue button
Then user get duplicate email warning

Scenario: user create account without filling details
Given user navigate to registration page
When user not enter any details
And user clicks on continue button
Then user get warning massage for mandatory fields 
