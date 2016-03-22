# XyralityTestTask
Java programming task: The LCS lottery
 
The LCS lottery lets people enter with a ticket number into a lottery. A winning number is drawn and every person gets credits in 
the amount of the longest common subsequence (LCS) with their own ticket number. The LCS is the longest (not necessarily contiguous) 
shared subsequence in two strings.  
For example the strings 1234567890 and 13153137531 share the LCS of 1357: 
 
A= 1234 5 67 890 
B= 1 3 15313 7531   LCS=135 7 
As a common programming problem, a lot of information about LCS is available in the usual sources as well (Wikipedia, etc.) Every person  
(uniquely identified by last name, first name and country) may enter with as many tickets as s/he likes. The list of participating players and their  
lottery numbers is supplied as a: 
 •  UTF-8, comma separated text file 
 •  no quotes around fields, fields themselves will not contain commas 
 •  field order is last name, first name, country, ticket number, names may contain
spaces 
 •  all fields can be arbitrarily long 

An example input file: 
Alison,Alice,Austria,1234567890  Bert,Bertram,Belgium,0987654321  Alison,Alice,Austria,9988776655  Carlson,Cynthia,China,1111999911  Carlson,Cynthia,Chile,1122334455  Daneson,Dan Dilbert,Denmark,4680468023  Dilbert Daneson,Dan,Denmark,0000000000  Eggbert,Eric,Estonia,9988778899 
Given a winning ticket number, every participant wins x credits for a ticket with an LCS of length x with the winning number. If a participant 
has multiple tickets that win credits, they win the sum of credits for all their tickets.   
Your task: given the input file of participants with their ticket numbers as stated above and a single winning number, please output a comma-separated  
list of people, that have won credits (and how many). Output them as a comma separated file in the format "last name, first name, country, amount of  
credits won". Aggregate all winnings per person into one line (e.g. in the example below, Alice Alison wins twice, 4 and 2 credits to a total of 6). The output  
should be sorted first by last name ascending, then first name ascending, then country ascending. Only participants, that won anything, should be listed. 
The final java program should be callable from the command line with parameters for the input file name and winning number and should output the  
results to the standard output. The use of libraries etc., of course, is fine where appropriate. 
An example: Winning number: 456000123, input file as given above   
Alison,Alice,Austria,1234567890 -> LCS 4560, 4 credits  Bert,Bertram,Belgium,0987654321 -> LCS 63 (or 53, 43, 03, ...), 2 credits  Alison,Alice,Austria,9988776650 -> LCS 50 (or 60), 2 credits  Carlson,Cynthia,China,1111999911 -> LCS 1, 1 credit  Carlson,Cynthia,Chile,1122334455 -> LCS 123, 3 credits 
Daneson,Dan Dilbert,Denmark,4680468023 -> LCS 460023, 6 credits 
Dilbert Daneson,Dan,Denmark,0000000000 -> LCS 000, 3 credits  Eggbert,Eric,Estonia,9988778899 -> none, 0 credits 
 
Output result: 
Alison,Alice,Austria,6 
Bert,Bertram,Belgium,2 
Carlson,Cynthia,Chile,3 
Carlson,Cynthia,China,1 
Daneson,Dan Dilbert,Denmark,6 
Dilbert Daneson,Dan,Denmark,3
