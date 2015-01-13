(Luokkakaavio on vaan tekstimuodossa, koska olen sokea, enkä siis itse hyödy kuvallisesta esityksestä lainkaan.)
Merkkejä:
- normaali yhteys
_ väliaikainen yhteys, katkoviiva
< > näkyvyysmääreet (vai mikä se termi on... ne nuolet kumminkin)
# perintänuoli 



[Pala]
[Omena]
[Mato]
[Matopeli]
[Aantentoistaja]
[Aani]
[AaniIlmoitin]
[Pistelaskuri]
[Pistehallinnoija]
[Kayttoliittyma]
[Tapahtumankuuntelija]

[Pala]1..*<-[Mato]
[Pala]#-[Omena]
[Matopeli]->[Mato]
[Matopeli]->[Omena]
[Aantentoistaja]->[Mato]
[Aantentoistaja]->[Omena]
[Matopeli]->[Aantentoistaja]
[Matopeli]->[AaniIlmoitin]
[Matopeli]->[Pistelaskuri]
[Matopeli]_[Pistehallinnoija]
[Kayttoliittyma]->[Matopeli]
[Kayttoliittyma]->[Tapahtumankuuntelija]
[Tapahtumankuuntelija]->[Matopeli]
[Tapahtumankuuntelija]->[Aantentoistaja]

