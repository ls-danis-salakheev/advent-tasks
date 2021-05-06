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

#### Task 4

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

---
#### Task 5 

The first 7 characters will either be *F* or *B*; these specify exactly one of the **128** rows on the plane (numbered 0 through 127). 
Each letter tells you which half of a region the given seat is in. Start with the whole list of rows; the first letter indicates whether the seat is in the front (0 through 63) or the back (64 through 127). The next letter indicates which half of that region the seat is in, and so on until you're left with exactly one row.

For example, consider just the first seven characters of **FBFBBFFRLR**:

- Start by considering the whole range, rows 0 through 127.
- F means to take the lower half, keeping rows 0 through 63.
- B means to take the upper half, keeping rows 32 through 63.
- F means to take the lower half, keeping rows 32 through 47. 
- B means to take the upper half, keeping rows 40 through 47.
- B keeps rows 44 through 47.
- F keeps rows 44 through 45.
- The final F keeps the lower of the two, row 44.

The last three characters will be either L or R; these specify exactly one of the 8 columns of seats on the plane (numbered 0 through 7). The same process as above proceeds again, this time with only three steps. L means to keep the lower half, while R means to keep the upper half.

For example, consider just the last 3 characters of **FBFBBFFRLR**:

Start by considering the whole range, columns 0 through 7.
R means to take the upper half, keeping columns 4 through 7.
L means to take the lower half, keeping columns 4 through 5.
The final R keeps the upper of the two, column 5.
>So, decoding FBFBBFFRLR reveals that it is the seat at row 44, column 5. More info [here](https://adventofcode.com/2020/day/5)

---
