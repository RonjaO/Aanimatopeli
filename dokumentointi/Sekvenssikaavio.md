(Kuten luokkakaaviot, t�m�kin vain tekstin�.) 

main -> Matopeli :: liikahdus()
  [<alt> jatkuu is false
    Matopeli :: stop()
    Matopeli -> Aantentoistaja :: lopeta(Aani.OMPPUYLOS)
    Matopeli -> Aantentoistaja :: lopeta(Aani.OMPPUALAS)
    Matopeli -> Aantentoistaja :: lopeta(Aani.OMPPUVASEN)
    Matopeli -> Aantentoistaja :: lopeta(Aani.OMPPUOIKEA)
  ]

  Matopeli -> AaniIlmoitin :: suunta()
    AaniIlmoitin -> Aantentoistaja :: kerroSuunta(Aani) [AaniIlmoitin laskee madon p��n ja omenan sijainnin mukaan, mink�                     Aani-arvon antaa Aantentoistajalle parametriksi]

  Matopeli -> AaniIlmoitin :: varoitukset()
    AaniIlmoitin :: matovaroitus() [kutsuu omaa metodiaan]
      [<loop> pala in mato.getPalat()
            [laskee madon p��n et�isyyden jokaisesta madon palasesta, jos et�isyys on enint��n kolme:]
        AaniIlmoitin -> Aantetoistaja :: toista(Aani.MATOVAROITUS)
      ]

    AaniIlmoitin :: seinavaroitus() [kutsuu omaa metodiaan]
           [laskee madon p��n et�isyyden seinist�, jos suunta on kohti sein��. Jos et�isyys kolme tai pienempi:]
      AaniIlmoitin -> Aantentoistaja :: toista(Aani.SEINAVAROITUS)

  Matopeli -> Mato :: liiku()

  [<alt> Mato :: osuu(Omena) is true
    Matopeli -> Aantentoistaja :: toista(Aani.SYOOMPPU)
              [lopettaa kaikki suuntaa ilmaisevat ��net]
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


