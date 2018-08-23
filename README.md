# SimpleMessages-Nemisys
This plugin is simple one. You can add custom message. Nemisys only.

I'm planning add:

- Much Much Placeholders.
- Messages per Server.
- Code performance.

I promiss.

I really wait for more ideas from you, guys :)
I will implement all any ideea you have.


Tip: If config.yml it's empty *can be*, replace values from src/main/java/resources/config.yml to your config.yml.

## Questions:

Probably much people are asking: What's difference of Nemisys and Nukkit?

With that plugin you can broadcast messages TO ALL SERVERS NEMISYS, THE SAME MESSAGE.

## Others:

If anyone want to make a banner/icon for plugin, dm me on discord: ⎰lim(x->0){[lg (sinh √(-πx))]}dx#6842

Forum Link: https://nukkitx.com/resources/simplemessages-nemisys.123/

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
  # & - Symbol Color
  # -------------------- About Time -----------------
    # %time - Time Now
    # %year - Time Year
    # %month - Month
    # %hour - Hour of Day
    # %minute - Minute
    # %second - Second
    # %dayOfYear - Day of Year
    # %dayOfMonth - Day of Month
    # %dayOfWeek - Day of Week
    # %dayOfWeekInMonth - Day of Week in Month
    # %weekOfMonth - Week of Month
    # %weekOfYear - Week of Year
    # %zoneOffset - Zone Offset
    # %milliseconds - Millseconds
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
  # Your Country
  # You can find list of all here: https://hastebin.com/awixusikan.m
  - 'Europe/Bucharest'
  ```