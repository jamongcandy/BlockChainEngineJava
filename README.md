# BlockChainEngineJava

## Product_v1.0
### To Start a Node
* Give node id(int) and blockchain size number(default is 0) as a cmd arguments.

Also give following options

"-a" : admin option, only admin can create genesis block.

"-m" : miner option, only miner can do mining.

"-t" : transaction creator option, only transaction creator can create new transaction.

"-o" : observer option. observers can only watch blockchain data.

  ex) start node 1 without blockchain size, with all node options.

  <code>>1 0 -a -m -t -o</code>

* To start a new node, open a new terminal.

  ex) start node 2 with blockchain size 50, with miner option.

  <code>>2 50 -m</code>

### Command List
"download" : download block chain data

"tx"     : node creates a transaction and broadcast to peers

"mining" : node creates a block, add it to blockchain and broadcast the block

"show"   : print blockchain

"addPeer" : add peer

"exit"   : exit program

"help"   : show command list





## TermProject_prototype2
### To Start a Node
* Start first node, give node id(int) as a cmd argument.

  ex) start node 111.

  <code>>111</code>

* To start a new node, open a new terminal and give another argument to download blockchain data

  ex) start node 222 and download existing blockchain data from node 111.

  <code>>222 111</code>

### Command List
"tx"     : node creates a transaction and broadcast to peers

"update" : node creates a block, add it to blockchain and broadcast the block

"show"   : print blockchain

"addPeer" : add peer

"exit"   : exit program

"help"   : show command list

