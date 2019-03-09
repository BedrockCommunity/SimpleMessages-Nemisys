# SimpleMessages-Nemisys
This plugin is simple one *and first nemisys plugin*. You can add custom message. Nemisys only.

I'm planning add:

- Much Much Placeholders.
- Messages per Server.
- Code performance.

I promiss.

I really wait for more ideas from you, guys :)
I will implement all any ideea you have.

## Questions:

Probably much people are asking: What's difference of Nemisys and Nukkit?

With that plugin you can broadcast messages TO ALL SERVERS NEMISYS, THE SAME MESSAGE.

## Others:

If anyone want to make a banner/icon for plugin, dm me on discord: NycuRO#0770

Forum Link: https://nukkitx.com/resources/simplemessages-nemisys.123/

## Config

```php
{
  "mechanic": {
    "period"          : 5,
    "async"           : true,
    "country"         : "Europe/Bucharest"
  },
  "messages": {
    "broadcast"       : [
      "&7Hello players! Now is %server_online players!",
      "&eNow is %time",
      "&6Thanks for playing on that server!",
      "&cHave fun guys! %motd"
    ]
  }
}
```

## PlaceHolders
```php
  # ----------------- Time Placeholders -----------------
    # %time - Time Now
    # %year - Time Year
    # %month - Month
    # %hour - Hour of Day
    # %minute - Minute
    # %second - Second
    # %milliseconds - Millseconds
    # %dayOfYear - Day of Year
    # %dayOfMonth - Day of Month
    # %dayOfWeek - Day of Week
    # %dayOfWeekInMonth - Day of Week in Month
    # %weekOfMonth - Week of Month
    # %weekOfYear - Week of Year
    # %zoneOffset - Zone Offset

  # ----------------- Server Placeholders ---------------
        # ---- Simple ---- #
    # %server_online - How much Players do you have on network
    # %motd - Motd of Nemisys
    # %server_players - Max Players
        # --- Mechanic -- #
    # %tps - TPS Nemisys
    # %tps_averange - Averange TPS Of Nemisys
    # %server_uptime - Server UpTime


   # ---------------- Chat Placeholders ------------------
    # & - Symbol Color
  ```
