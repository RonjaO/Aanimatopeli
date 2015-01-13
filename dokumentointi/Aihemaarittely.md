Aihe: Äänimatopeli
Äänimatopeli on versio matopelistä, jota voi pelata näkemättä ruutua, pelkkien äänien avulla. Matoa ohjataan nuolinäppäimillä, kuten tavallisesti, mutta omenan sijainti madon päähän nähden ilmaistaan äänillä. Matopelissä käytettävät äänet voi kuunnella halutessaan ennen pelaamista. Pelissä saa pisteen syötyään omenan.


Rakennekuvaus
Äänimatopelin kaikki luokat ovat pakkauksen aanimatopeli alla. Sieltä löytyy alipakkauksina aanet, domain, gui, peli ja pisteet. 

Peli rakentuu pelilogiikasta (luokka matopeli pakkauksessa peli), käyttöliittymästä (pakkauksen gui sisältö) madosta ja omenasta (pakkaus domain), äänten toistamiseen tarvittavista luokista (pakkaus aanet) sekä pistelaskuun käytettävistä luokista (pakkauksessa pisteet). Pelin mato koostuu pala-oliosta ja pelin omena on myös pala. Matopeli käyttää matoa ja omenaa sekä äänten toistamiseen tarvittavia luokkia, kuten myös graafisen käyttöliittymän tekstikenttää ja AaniIlmoitin-luokkaa. Matopeli käyttää myös pistelaskussa pistelaskuria ja tallettaa pisteet muistiin pistehallinnoijan kautta.

Käyttöliittymän kaverina on tapahtumankuuntelija, jolla on yhteys matopeliin sekä ääntentoistajaan, myös käyttöliittymän tekstikenttään. Näppäimistönkuuntelija aktivoituu, kun peli on käynnissä, ja tuntee muista luokista vain madon, jonka kulkusuuntaan se vaikuttaa. 