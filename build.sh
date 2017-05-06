#!/bin/bash
# Build para sfml

echo "ahh muleke"

mkdir dist
cd dist
LOCAL_PATH=$(cd $(dirname "$1") && pwd -P)/$(basename "$1")
echo $LOCAL_PATH

echo ${LOCAL_PATH//dist/src}




