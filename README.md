WBA2VL
======

Aufbau eines News Pushing Systems für einen Online Videothek im Rahmen des
Projekts für Webbasierte Anwendungen, Teil 2 / Medieninformatik.

## Zielsetzung:  
Entwicklung eines RESTfull Video On Demand Server-Client Systems, dass in der Lage ist, Infos zu Neuerscheinungen im XML Format asynchron auf einen Client zu puschen.
Weiterhin eine Synchronisierung des Clients mit dem Index des Servers nach erfolgter Anmeldung am Dienst.


## Infrastruktur:
###Server: 
- Webserver ( HTTP )
- Streaming Server ( RTP )
- Push Server ( XMPP )
- IP-Stack Server ( HTTP )

###Client:
- Android App
- Java Swing App

## Problemstellung:  
- Addresshandling
- Realisierung Push Service
- Synch bei Anmeldung
- Tomcat ?


