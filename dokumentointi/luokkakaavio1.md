(Luokkakaavio on vaan tekstimuodossa, koska olen sokea, enk� siis itse hy�dy kuvallisesta esityksest� lainkaan.)
Merkkej�:
- normaali yhteys
_ v�liaikainen yhteys, katkoviiva
< > n�kyvyysm��reet (vai mik� se termi on... ne nuolet kumminkin)
# perint�nuoli 



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

