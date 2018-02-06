# GSP Auction Implementation
# Based on paper "Internet Advertising and the Generalized Second-Price Auction : Selling Billions of Dollars Worth of Keywords"
# by Benjamin Edelman, Michael Ostrovsky and Michael Schwarz

import numpy as np
from operator import itemgetter

print("\n------------------------------------")
print("\n        GLS Auction Program")
print("\n------------------------------------")

N  = int(input("\nEnter Number of Advertisement Slots : ")) # Number of objects
K  = int(input("\nEnter Number of Advertisers/Bidders : ")) # Number of bidders
reserve_price  = float(input("\nEnter Reserve Price : ")) # Reserve price in Dollar

# N = 2 # Number of objects # Testing
# K = 3 # Number of bidders # Testing
# reserve_price = 0.1 # Reserve price in Dollar # Testing

alpha = np.zeros(N)  # Initializing click through rate
bids =  np.zeros(K)  # Initializing bids for bidders
value = np.zeros(K)  # Value per click for bidders
auctioneer_revenue = 0 # Revenue for auctioneer per period
temp = 0

for i in range(N):
    alpha[i] = (N - i + 1)*1000/8  # Click through rate randomly assigned,
                                   # you can change if you want method to
                                   # assign click through rates per period
                                   # for slots.

# print(alpha)

print("\n------------------------------------")

for i in range(K):
    value[i] = float(input("\nEnter value per click for the bidder " + str(i + 1) + " : "))    # Click through rate randomly assigned

print("\n------------------------------------")

for i in range(K):
    bids[i] = float(input("\nEnter bid by the bidder " + str(i + 1) + " : "))    # Click through rate randomly assigned

indices, bids_sorted = zip(*sorted(enumerate(bids), key=itemgetter(1), reverse=True))

# print(bids)
# print(bids_sorted)
# print(indices)

# Payment and Payoff calculation

print("\n-------------------------------------")
print("\nPlayers and their payments per Period")
print("\n-------------------------------------")


if K <= N:
    for j in range(K):
        if j<K-1:
            if bids[j] == bids_sorted[j+1]:
                if j == K-2:
                    temp = float(alpha[j]*reserve_price)
                else:
                    temp = float(alpha[j]*bids_sorted[j+2])
            else:
                temp = float(alpha[j]*bids_sorted[j+1])
            print("\nSlot " + str(j + 1) + " is occupied by Bidder "+ str(indices[j] + 1) + ", his/her Payment : " + str(temp))
            print("Payoff for this player is " + str(float(alpha[j]*value[indices[j]] - temp)))
            auctioneer_revenue = auctioneer_revenue + temp
        else:
            temp = float(alpha[j]*reserve_price)
            print("\nSlot " + str(j + 1) + " is occupied by Bidder "+ str(indices[j] + 1) + ", his/her Payment : " + str(temp))
            print("Payoff for this player is " + str(float(alpha[j]*(value[indices[j]] - reserve_price))))
            auctioneer_revenue = auctioneer_revenue + temp
else:
    for j in range(N):
        if bids[j] == bids_sorted[j+1]:
            if j == K-2:
                temp = float(alpha[j]*reserve_price)
            else:
                temp = float(alpha[j]*bids_sorted[j+2])
        else:
            temp = float(alpha[j]*bids_sorted[j+1])
        print("\nSlot " + str(j + 1) + " is occupied by Bidder "+ str(indices[j] + 1) + ", his/her Payment : " + str(temp))
        print("Payoff for this player is " + str(float(alpha[j]*value[indices[j]] - temp)))
        auctioneer_revenue = auctioneer_revenue + temp

print("\n------------------------------------")
print("\nThe Revenue of Auctioneer per Period is : " + str(auctioneer_revenue))


