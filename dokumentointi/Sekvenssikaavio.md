(Kuten luokkakaaviot, tämäkin vain tekstinä.) 

main -> Matopeli :: liikahdus()
  [<alt> jatkuu is false
    Matopeli :: stop()
    Matopeli -> Aantentoistaja :: lopeta(Aani.OMPPUYLOS)
    Matopeli -> Aantentoistaja :: lopeta(Aani.OMPPUALAS)
    Matopeli -> Aantentoistaja :: lopeta(Aani.OMPPUVASEN)
    Matopeli -> Aantentoistaja :: lopeta(Aani.OMPPUOIKEA)
  ]

  Matopeli -> AaniIlmoitin :: suunta()
    AaniIlmoitin -> Aantentoistaja :: kerroSuunta(Aani) [AaniIlmoitin laskee madon pään ja omenan sijainnin mukaan, minkä                     Aani-arvon antaa Aantentoistajalle parametriksi]

  Matopeli -> AaniIlmoitin :: varoitukset()
    AaniIlmoitin :: matovaroitus() [kutsuu omaa metodiaan]
      [<loop> pala in mato.getPalat()
            [laskee madon pään etäisyyden jokaisesta madon palasesta, jos etäisyys on enintään kolme:]
        AaniIlmoitin -> Aantetoistaja :: toista(Aani.MATOVAROITUS)
      ]

    AaniIlmoitin :: seinavaroitus() [kutsuu omaa metodiaan]
           [laskee madon pään etäisyyden seinistä, jos suunta on kohti seinää. Jos etäisyys kolme tai pienempi:]
      AaniIlmoitin -> Aantentoistaja :: toista(Aani.SEINAVAROITUS)

  Matopeli -> Mato :: liiku()

  [<alt> Mato :: osuu(Omena) is true
    Matopeli -> Aantentoistaja :: toista(Aani.SYOOMPPU)
              [lopettaa kaikki suuntaa ilmaisevat äänet]
    Matopeli -> Mato :: kasva()

    Matopeli :: luoOmena () [kutsuu omaa metodiaan, asettaa metodin paluuarvona saadun uuden omenan omenaksi]

    Matopeli -> AaniIlmoitin :: setOmena(Omena)
  ]

  [<alt> Mato :: osuuItseensa() is true 
    Matopeli -> Aantentoistaja :: toista(Aani.TORMAAITSEENSA)
            [asettaa jatkuu-muuttujan arvoksi false]
  ]

  [<alt> Mato :: getPaa().getX() is < 0 or Mato :: getPaa().getX() is > leveys 
    Matopeli -> Aantentoistaja :: toista(Aani.TORMAYS)
            [asettaa jatkuu-muuttujan arvoksi false]
  ]
  [<alt> Mato :: getPaa().getY() is < 0 or Mato :: getPaa().getY() is > korkeus 
    Matopeli -> Aantentoistaja :: toista(Aani.TORMAYS)
            [asettaa jatkuu-muuttujan arvoksi false]
  ]


