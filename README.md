## Info

This project includes some solves to daily tasks from [Adventofcode](https://adventofcode.com).

----

#### Task 1

Specifically, they need you to find the two entries that sum to 2020 and then multiply those two numbers
together... [more](https://adventofcode.com/2020/day/1)

---

#### Task 2

For example, suppose you have the following list:
> 1-3 a: abcde
>
> 1-3 b: cdefg
>
> 2-9 c: ccccccccc

Each line gives the password policy and then the password. The password policy indicates the lowest and highest number
of times a given letter must appear for the password to be valid. For example, `1-3` a means that the password must
contain a at least `1` time and at most `3` times. More info [here](https://adventofcode.com/2020/day/2)
---

#### Task4

The automatic passport scanners are slow because they're having trouble detecting which passports have all required
fields. The expected fields are as follows:

- byr (Birth Year)
- iyr (Issue Year)
- eyr (Expiration Year)
- hgt (Height)
- hcl (Hair Color)
- ecl (Eye Color)
- pid (Passport ID)
- cid (Country ID)

Passport data is validated in batch files (your puzzle input). Each passport is represented as a sequence of `key:
value` pairs separated by spaces or newlines. Passports are separated by blank lines.

Here is an example batch file containing four passports:

1. [x] `ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm` 

2. []`iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884 hcl:#cfa07d byr:1929`

3. [x] `hcl:#ae17e1 iyr:2013 eyr:2024 ecl:brn pid:760753108 byr:1931 hgt:179cm`

4. []`hcl:#cfa07d eyr:2025 pid:166559648 iyr:2011 ecl:brn hgt:59in`