# SimpleMessages-Nemisys
This plugin is simple one. You can add custom message. Nemisys only.

I'm planning add:

- Much Much Placeholders.
- Messages per Server.

I really wait for more ideas from you, guys :)
I will implement all any ideea you have.


Tip: If config.yml it's empty *can be*, replace values from src/main/java/resources/config.yml to your config.yml.

## Config

```php
##################################################################
# Welcome to Config!
# This config is very easy to configurate.
#############################################################


## Messages
messages:
  # There you put messages what you want sended.
  # Have support for:
  # %server_online - how much players are online on all network
  # %motd - motd of network
  # %tps - tps synapse
  # %server_players - max players what server can have
  # %tps_averange - Averange TPS Of Server
  # %server_uptime - Server UpTime
  # %time - Time Now
  # & - Symbol Color
  broadcast:
  - '&7Hello players! Now is %server_online players!'
  - '&eNow is %time'
  - '&6Thanks for playing on that server!'
  - '&cHave fun guys! %motd'

##
## Mechanic Things
##
mechanic:
  # I used Array instanceof more variables.
  values:
  # Period of repeating message in Seconds.
  # Is send only one message. Not all.
  - '5'
  # If you MessageTask to be Async.
  # If you are new with nemisys and don't know what use, use true.
  - 'true'
  ```