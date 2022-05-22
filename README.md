<p align="center"> 
  <h3 align="center"> Chord Backup System </h3> 
  <p align="center"> Implementation of a efficient backup system using chord algorithm </p> 
</p> 

## Overview 
The aim of this project is to elaborate a distributed system service for backing up files on the Internet.

## Compile and Run 
Under the root folder of our project, to compile our java code run: `make`.  
You can also run the following command if you want to delete the generated files: `make clean`. 

After this, to initialize the peer you should go to ./out folder and run the following command where $IP is the IP of the peer and $PORT an open port of the peer. This command will initialize a peer, that will be responsible for also initializing the Chord Ring and system.

```
sh ../scripts/peer.sh $IP $PORT
```

If you already have a Chord Ring initialized, you can run the following command where $CHORD_NODE_IP and $CHORD_NODE_PORT are respectively the IP and PORT of one peer already connected to the Chord Ring.

```
sh ../scripts/peer.sh $IP $PORT $CHORD_NODE_IP $CHORD_NODE_PORT
```

## Operations supported 

To run any operation of the backup service, it’s necessary to write on the terminal the command: 
```
sh ../scripts/protocol.sh $PROTOCOL
```

Where $PROTOCOL can be one of the following:
- $IP $PORT BACKUP $FILE_PATH $REP_DEG
- $IP $PORT RESTORE $FILE_NAME
- $IP $PORT DELETE $FILE_NAME
- $IP $PORT RECLAIM $PEER_ID $SPACE


### Backup 
The backup protocol is responsible to save files with the desired replication degree among the peers.
```
$IP $PORT BACKUP $FILE_PATH $REP_DEG
```

- IP - IP of the host to invoke the backup
- PORT - PORT of the host to invoke the backup
- FILE_PATH - Path of the file to backup

### Restore 

The restore protocol is responsible to restore files that exist at any point of the network. The initiator peer doesn’t need to be the one that backed up the file that is asking to restore.

```
$IP $PORT RESTORE $FILE_NAME
```

- IP - IP of the host to invoke the restore
- PORT - PORT of the host to invoke the restore
- FILE_NAME - Name of the file to restore

### Delete

The delete protocol is responsible to delete backed up files that exist at any point of the network. The initiator peer doesn’t need to be the one that backed up the file that is asking to delete.

``` 
$IP $PORT RECLAIM $PEER_ID $SPACE
```

- IP - IP of the host to invoke the delete
- PORT - PORT of the host to invoke the delete
- FILE_NAME - Name of the file backed up to delete

### Reclaim 
```
$IP $PORT RECLAIM $PEER_ID $SPACE
```

- IP - IP of the host to invoke the reclaim
- PORT - PORT of the host to invoke the reclaim
- PEER_ID - ID of the peer which will be reclaimed
- SPACE - Size of space to be reclaimed in KB


## Report 
For more information checkout the [report](https://github.com/Jumaruba/ChordBackupSystem/blob/FixFingers/doc/Report.pdf). 
## Group members:

1. Diogo Fernandes up201806250@fe.up.pt
2. Juliane Marubayashi up201800175@fe.up.pt


