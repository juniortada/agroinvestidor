mkdir obj
mkdir obj/Debug
mkdir obj/Debug/modules
mkdir obj/Debug/modules/tmxlite
mkdir obj/Debug/modules/tmxlite/src
mkdir obj/Debug/modules/tmxlite/src/detail
mkdir obj/Debug/src
mkdir bin
mkdir bin/Debug

g++ -Wall -fexceptions -g -Imodules/tmxlite/include -c $PWD/modules/tmxlite/src/detail/pugixml.cpp -o obj/Debug/modules/tmxlite/src/detail/pugixml.o -std=c++14
g++ -Wall -fexceptions -g -Imodules/tmxlite/include -c $PWD/modules/tmxlite/src/FreeFuncs.cpp -o obj/Debug/modules/tmxlite/src/FreeFuncs.o -std=c++14
g++ -Wall -fexceptions -g -Imodules/tmxlite/include -c $PWD/modules/tmxlite/src/ImageLayer.cpp -o obj/Debug/modules/tmxlite/src/ImageLayer.o -std=c++14
g++ -Wall -fexceptions -g -Imodules/tmxlite/include -c $PWD/modules/tmxlite/src/Map.cpp -o obj/Debug/modules/tmxlite/src/Map.o -std=c++14
gcc -Wall -fexceptions -g -Imodules/tmxlite/include -c $PWD/modules/tmxlite/src/miniz.c -o obj/Debug/modules/tmxlite/src/miniz.o -std=c++14
g++ -Wall -fexceptions -g -Imodules/tmxlite/include -c $PWD/modules/tmxlite/src/Object.cpp -o obj/Debug/modules/tmxlite/src/Object.o -std=c++14
g++ -Wall -fexceptions -g -Imodules/tmxlite/include -c $PWD/modules/tmxlite/src/ObjectGroup.cpp -o obj/Debug/modules/tmxlite/src/ObjectGroup.o -std=c++14
g++ -Wall -fexceptions -g -Imodules/tmxlite/include -c $PWD/modules/tmxlite/src/Property.cpp -o obj/Debug/modules/tmxlite/src/Property.o -std=c++14
g++ -Wall -fexceptions -g -Imodules/tmxlite/include -c $PWD/modules/tmxlite/src/TileLayer.cpp -o obj/Debug/modules/tmxlite/src/TileLayer.o -std=c++14
g++ -Wall -fexceptions -g -Imodules/tmxlite/include -c $PWD/modules/tmxlite/src/Tileset.cpp -o obj/Debug/modules/tmxlite/src/Tileset.o -std=c++14
g++ -Wall -fexceptions -g -Imodules/tmxlite/include -c $PWD/src/main.cpp -o obj/Debug/src/main.o -std=c++14
g++  -o bin/Debug/teste obj/Debug/modules/tmxlite/src/detail/pugixml.o obj/Debug/modules/tmxlite/src/FreeFuncs.o obj/Debug/modules/tmxlite/src/ImageLayer.o obj/Debug/modules/tmxlite/src/Map.o obj/Debug/modules/tmxlite/src/miniz.o obj/Debug/modules/tmxlite/src/Object.o obj/Debug/modules/tmxlite/src/ObjectGroup.o obj/Debug/modules/tmxlite/src/Property.o obj/Debug/modules/tmxlite/src/TileLayer.o obj/Debug/modules/tmxlite/src/Tileset.o obj/Debug/src/main.o -lsfml-graphics -lsfml-window -lsfml-system -std=c++14

ln -s bin/Debug/teste