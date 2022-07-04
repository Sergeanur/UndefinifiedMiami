# UndefinifiedMiami

Miami .sc files cured from the 3master plague. Posted for educational purposes.

## How to browse between versions

This repo has versions commitied on top of each other in chronological order, so that you could easily see the changes each version provided.

The shipped versions were marked by tags which you could browse:
- **ps2_1.60**
- **ps2_2.01**
- **pc**
- **xbox_debug** (note: these were the changes found only in debug script that the game doesn't use)
- **ps2_3.00**
- **ps2_jp**
- **pc_jp**

Branches:
- **master** - checked out on PC 1.00 since this is the most popular version
- **latest** - checked out on PC JP release. This is the latest version with all fixes applied, but with Haitian-friendly censorship
- **latest_uncensored** - PC JP version with censorship reverted. Technically the ultimate version with all fixes and no cuts.

## How to compile

You need to get miss2.exe from 3master and then patch the 3master plague out of it.
To patch miss2.exe, put it in `patch` directory and launch **xdelta3.bat**. Now you can use miss2.exe that would produce correct compiled binaries (and is also compatible with Japanese commands).
Note: starting from **ps2_jp** the debug version (main_d) cannot be compiled since it has more labels than miss2.exe can handle. This might be fixed in the future.

## Changelog

- **2022/07/04**: removed plague leftover in prot1.sc
- **2022/06/30**: removed plague leftover in inital.sc
- **2022/06/24**: repo reassembled due to git bug that failed to see all the changes in files properly
- **2022/06/17**: original release
