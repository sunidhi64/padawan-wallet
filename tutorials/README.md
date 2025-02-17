# Readme
This file is a 1-to-1 mapping of the tutorials in the app. It is meant as an easy way for developers to visualize and consume what is in the tutorials and open PRs for bettering them. 

If you are not comfortable opening a PR but have ideas on how to improve the tutorials, please propose changes through a GitHub issue, or join our [Discord channel] and come discuss your ideas there!

The tutorials are currently capped at an arbitrary 5000 characters per. This is not a technical requirement of the app but simply a way to keep the tutorials light and quickly digestible. Please consider the cap when opening pull requests.  
<br/>

# Tutorial 1: What is the Bitcoin testnet? — Concept
You should think of the Bitcoin network as thousands of computers who speak a common language and communicate with each other over the internet. But even though the biggest and most well known of these computer networks is the one you're most familiar with and the one most people speak of when they say "the Bitcoin network", there are in fact three different types of Bitcoin networks one might use.

The most well known of those is called _mainnet_, and refers to the bitcoins that have monetary value and can be traded on exchanges. The other two networks are built for testing and training, and are used by software developers who need to develop and test their software, and by humans who wish to learn how to use Bitcoin without the worry of protecting and sending around "real" (mainnet) bitcoins.

Those two testing networks are called the regtest (short for _regression testing network_) and testnet (short for _test network_).

### Regtest
The regtest network is a sort of "micro" bitcoin network software developers use to start an instance of a bitcoin network locally (on a single computer, for example, or between a few computer under a single person's control). It is useful because one can control all aspects of the network and nodes (mining new blocks, creating and deleting nodes, etc.). It is a network that is almost uniquely used by software developers.

### Tesnet
The testnet consists of a full-fledged bitcoin network that is available worldwide, and connects thousands of nodes (just like mainnet). The bitcoins on this network are often called _testnet coins_, and look and behave most identically to normal bitcoin, except that they have no value! This feature is extremely useful for testing applications in the real world. It also allows curious minds to explore bitcoin in a real way, make transactions, back up wallets, and understand the foundational building blocks of the network without having to touch real bitcoin before they get comfortable with the basic set of heuristics that bitcoin requires users to understand in order to use it safely and effectively.  
<br/>

# Tutorials 2: Bitcoin units — Concept
It is unfortunate but the word "bitcoin" has two completely different meanings. We speak of _Bitcoin_ the network, the protocol, the open source project, and we also use the word "bitcoin" as one of the units of value when transacting on that network.

A bitcoin is a unit of value that can easily be broken down in smaller parts. Just like the kilometer can be broken down into meters and centimeters and the dollar can be broken down into quarters, dimes, and pennies, bitcoin can be broken into smaller units.

While there are many units to describe bitcoin, we believe only two of those to be important: the _bitcoin_ and the _satoshi_. There are one hundred million (100,000,000) satoshis in a bitcoin.

100,000,000 satoshis = 1 bitcoin\n1 satoshi = 0.00000001 bitcoin

Depending on the size of a transaction, it is often more appropriate to think of the amount transacted as being in bitcoin or in satoshis. A brand new car might be worth 1.7 bitcoins (1,700,000,000 sats is not as easy for the eye to quickly understand), whereas a candy might be worth 250 satoshis (0.00000250 bitcoin is harder to read).

The ability to use both units is an important skill to develop. A lot of transactions are denominated in bitcoin, but their _network fee_ (tutorial #4) is almost always written in satoshis.

You can switch between the two units in the main wallet display page by touching the bitcoin/satoshi symbol.

[include image bitcoin and image satoshi]  
<br/>

# Tutorial 3: Receiving Bitcoin — Skill
You will find that Padawan only uses testnet bitcoins. Make sure you never send it real bitcoins!

The way to receive bitcoin is typically to ask your wallet software—in our case, Padawan—to generate what is called a _receive address_. Deep down, this address is simply a really, really big number. But to make sure it is easy to share, copy/paste, and scan, we display that address in one of two common forms; either a string of numbers and letters that looks like this one: `tb1lkjs`, or a QR code that looks like this:

The two formats above actually refer to the same address.

To receive bitcoin, you would either ask the person trying to send you the coins to scan the QR code displayed on your screen when you generate an address (if the person is nearby), or you would copy the address string generated by the wallet and paste it in a message to them, preferably on a secure and encrypted chat. You can do that by touching the address on the screen. The wallet will offer you to put that address on the clipboard for you.

It\'s very important that the _exact_ right address be used by the person trying to send you bitcoins. QR codes are a good way to prevent errors for that, and using the copy/paste function of your phone\'s clipboard is another way to do it. Still, you should always double check that the complete address was read/transferred to the person trying to send you bitcoin! A common way to do that is to read aloud the letters/numbers, or, for smaller transactions, to look at the first 5 to 10 characters and the last 5 to 10 characters of an address and verify that they are the same.  
<br/>

# Tutorial 4: What is the mempool? — Concept
Mempool stands for memory pool, and you can think of it as the place where transactions go before they get mined and become "official". When you send a transaction on the bitcoin network, your transaction get propagated across all computers that comprise the bitcoin network all over the world in about 2 to 5 seconds. But at this point your transaction is not really done, i.e. included in the blockchain. Instead, it sorts of waits in this "in-between" space where it is acknowledged by the network, but not yet made official.

We can think of this space (the mempool) as a theoretical place where transactions all come together and form a lineup, waiting for the next block to be mined to include many of them. Imagine an bus that comes by a lineup of people waiting to go to their part of town every 10 minutes or so. This bus can take only a certain number of pounds on board, and because everyone weights a different weight, the exact number of people who can fit in the bus at every run is different.

The mempool is the area where transactions wait for their turn to be mined. One special thing about this "lineup" of transactions that are all waiting to be made official (to get "mined", or included in the next bitcoin block), is that you can bid money to make sure you are up near the front of the line if you need to, or, inversely, you can save a lot of money by not bidding much if you are not worried about speed and you have time for this transaction to be mined. Eventually, (at the moment every weekend or so), the line clears and every transaction waiting in line does get through.  
<br/>

# Tutorial 5: Sending Bitcoin — Skill
We send bitcoins by paying to a bitcoin address. On mobile phones, the most common way to do that is to use your phone\'s camera to scan a QR code of the person or service you wish to pay. Another way is to have that person or service send you the address directly, and copy/pasting that address in the address field of the transaction builder.

Once we have an address, we also specify the amount of bitcoin to send (either in bitcoin units or in satoshis), and broadcast the transaction to the network!  
<br/>

# Tutorials 6: What are transaction fees? — Concept
The action of sending a transaction over the bitcoin network and having that transaction be validated, confirmed and stored across thousands of computers over the world is immensely valuable; it\s also very costly.

The ability of the network to stay synchronized and distributed (which are properties important for further aspects that make it valuable, such as it\'s censorship-resistance and its apolitical nature) implies that the load that the network can take in terms of transactions per minute is limited. The leaner and lighter the load on the network, the more resistant it is to attacks, and the more neutral and robust it stays. This desire to stay lean comes in contrast with the demand for transactions by Bitcoin users, and the balance between the two is struck by having a limited amount of space for the total amount of bytes that can be transacted over the network per amount of time, yet allowing people to "bid" on that space.

Because the space is limited in terms of bytes per block (there is only 1 new block being mined every 10 minutes or so), bitcoin users compete for "space" on the blockchain by providing a fee for their transaction. The transactions with the highest fees are prioritized by the miners, and get included in the block they mine.  
<br/>

# Tutorial 7: What is a wallet backup seed? — Concept
Modern bitcoin wallets almost all use a process called _deterministic key generation_, where every new address is generated in a non-random fashion. This gives them the property of being very flexible in terms of generating new addresses (you\'ll notice that every bitcoin receive transaction uses a new address), while not having to remember them all (you do not have to make individual backups for all the addresses to which you received bitcoin). In fact the process looks a little bit like in the following diagram, where each "branch" of the tree is a process known in advance and shared across all bitcoin wallets:

image

The number of addresses that can be generated from this tree is infinite, yet because the process to generate new keys (the path the branches need to follow) is predetermined, the _only_ necessary part of backing up such a "tree of addresses" is to remember the root of the tree!

The real word for this "root" of your wallet is the _wallet seed_. This wallet seed is simply a really, really big number, but numbers are notoriously hard to remember, and humans are usually really bad at writing them down properly without making mistakes or typos. Instead, a standard for how to encode these really big numbers has emerged in the bitcoin ecosystem. This standard uses a series of 12 or 24 words in a specific order, which together can always be used to recreate the wallet seed.

Padawan uses this standard to allow users to create backups for its wallet. You'll find the 12 words (we call those your seedphrase) on a separate screen under the drawer options. Those words should be treated with the _utmost_ care. They hold the key to all the bitcoin stored in a wallet.  
<br/>

# Tutorial 8: Recovering your wallet from a backup seed — Skill
Recovering a wallet from a mnemonic is usually fairly easy. Mnemonics use a standard called BIP39, which usually provides a common way to recover coins between different wallet implementations. The usual pattern for backing up and recovering a wallet is the following:\n

1. We create a wallet and the software will provide us with either 12 or 24 words to write down and keep. The order of the words is important, so make sure you write them in the right order. In Padawan, you can see those 12 words at any time by going into the "Show Seed Phrase" screen. In most other wallet implementations, you will only get a chance to see those words once, SO MAKE SURE YOU WRITE THEM DOWN AND TREAT THEM LIKE THE MONEY THEY REPRESENT. Upon creating a new wallet, you can always try to send a tiny amount of bitcoin to the wallet, delete the wallet, and attempt a full recovery using the words provided by the wallet. If all goes well and you backed up your wallet correctly, you will be able to re-enter the same wallet and the coins will be there.

In Padawan, you'd click on "I already have a Padawan wallet" and enter your 12 words mnemonic.

This ability to recover a wallet using only your words is very powerful, because it means that you don't actually need the wallet to be installed on your phone to transport your bitcoin; you can simply keep the 12 words somewhere safe (learning them by heart is also often useful, although you should not rely on that uniquely).

This aspect of bitcoin software is often misunderstood and is worth taking the time to appreciate; bitcoins are not "held" in any mobile or desktop wallet. They are simply accessed through them. But the testnet coins you have on Padawan can be recovered and used on a range of other mobile, desktop, and hardware wallets that support BIP39 bitcoin wallets. If your mnemonic words are properly backed up, deleting the app on your phone is not an issue at all!
