Aihe: ��nimatopeli
��nimatopeli on versio matopelist�, jota voi pelata n�kem�tt� ruutua, pelkkien ��nien avulla. Matoa ohjataan nuolin�pp�imill�, kuten tavallisesti, mutta omenan sijainti madon p��h�n n�hden ilmaistaan ��nill�. Matopeliss� k�ytett�v�t ��net voi kuunnella halutessaan ennen pelaamista. Peliss� saa pisteen sy�ty��n omenan.


Rakennekuvaus
��nimatopelin kaikki luokat ovat pakkauksen aanimatopeli alla. Sielt� l�ytyy alipakkauksina aanet, domain, gui, peli ja pisteet. 

Peli rakentuu pelilogiikasta (luokka matopeli pakkauksessa peli), k�ytt�liittym�st� (pakkauksen gui sis�lt�) madosta ja omenasta (pakkaus domain), ��nten toistamiseen tarvittavista luokista (pakkaus aanet) sek� pistelaskuun k�ytett�vist� luokista (pakkauksessa pisteet). Pelin mato koostuu pala-oliosta ja pelin omena on my�s pala. Matopeli k�ytt�� matoa ja omenaa sek� ��nten toistamiseen tarvittavia luokkia, kuten my�s graafisen k�ytt�liittym�n tekstikentt�� ja AaniIlmoitin-luokkaa. Matopeli k�ytt�� my�s pistelaskussa pistelaskuria ja tallettaa pisteet muistiin pistehallinnoijan kautta.

K�ytt�liittym�n kaverina on tapahtumankuuntelija, jolla on yhteys matopeliin sek� ��ntentoistajaan, my�s k�ytt�liittym�n tekstikentt��n. N�pp�imist�nkuuntelija aktivoituu, kun peli on k�ynniss�, ja tuntee muista luokista vain madon, jonka kulkusuuntaan se vaikuttaa. 