WBA2VL
======

Aufbau eines News Pushing Systems für einen Online Videothek im Rahmen des
Projekts für Webbasierte Anwendungen, Teil 2 / Medieninformatik.

## Zielsetzung:  
Entwicklung eines RESTfull Videothek Systems, dass in der Lage ist, Infos zu Neuerscheinungen im XML Format asynchron auf einen Client zu puschen.
Weiterhin eine Synchronisierung des Clients mit dem Index des Servers nach erfolgter Anmeldung am Dienst.
Zusätzlich eine Möglichkeit für Operator neue Filme und Daten einstellen zu können.


## Infrastruktur:
###Server: 
- Webserver ( HTTP ) + IP-Stack Server ( HTTP )  
Hierbei werden wir auf bestehende Software in Form des offenen Webservers Apache zurückgreifen.  
Dieser dient einerseits dazu, den IP Stack für bestehende Cients zu halten.( Dient der Addressierung der  
Push Notification. Dieses Problem könnte auch über eine Google Api gelöst werden. Allerdings müssten dann  
Services in der Google Cloud mit eingebunden werden, wogegen wir uns für dieses Projekt entschieden haben. 

- Streaming Server ( RTP )
- Push Server ( XMPP )  
Hierbei werden wir auf bestehende Software in Form des offenen XMPP Servers Openfire zurückgreifen.  
[http://www.igniterealtime.org/projects/openfire/index.jsp](http://www.igniterealtime.org/projects/openfire/index.jsp)



###Client:
- Android App mit XMPP Client
- Java Swing App

## Problemstellung:  
- Addresshandling
- Realisierung Push Service
- Synch bei Anmeldung
- Tomcat ?


