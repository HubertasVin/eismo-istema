# Mario platformer žaidimas
## Paskirtis
Eismo sistemos simuliacija, kurios tikslas yra simuliuoti eismo dalyvių judėjimą gatve.
## Paleidimas
Paleidžiant ./runjavafile.sh failą..
## Funkcionalumas
- Eismo dalyviai gali pasirinkti atsitiktinę kelio dalį ir nuvažiuoti iki jos.
- Egzistuoja du eismo dalyvių tipai: mašina ir dviratininkas.
- Galima piešti kelius ir pridėti naujų eismo dalyvių į eismo sistemą ir išsaugoti bei užkrauti pakeistus duomenis.

## Pagrindinės klasės
- `SimulationPanel` - Sukuria užima dalį atidaryto lango ir jame vaizduoja vykstančią simuliaciją.
- `RoadUser` - klasė, iš kurios kyla visi eismo dalyviai - mašinos ir dviratininkai.
- `LevelManager` - klasė, atsakinga už lygių nuskaitymą ir konvertavimą į žaidžiamą aplinką.
- `LoadData` - klasė atsakinga už simuliacijos išsaugotos būsenos užkrovimą iš failo.
- `SaveData` - klasė atsakinga už simuliacijos būsenos išsaugojimą faile.
- `Constants` - klasė, kuri laiko konstantas, kurios naudojamos visame projekte.
- `SandboxData` - klasė, kurioje saugomi pagrindiniai kintamieji, kurie naudojami visame projekte.

## Plėtimo galimybės
- Šviesoforų sistemos.
- Eismo dalyvių susidūrimo tikrinimas.
- Kintamas eismo lygis tam tikru paros metu.
- Kamščių simuliacija.
- Nubraižytos eismo sistemos efektyvumas balais.
- Įdėti pėsčiuosius, kurie eitų tik pėsčiųjų takais, bei dviratininkus, kurie važiuotų tik dviračių takais.
- "Custom" sankryžų kūrimas (žiedai, bendros erdvės ir kt.).

## Projektavimo šablonai
- `BuildSelectButton` - gamyklos (factory) projektavimo šabloną