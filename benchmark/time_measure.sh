#!/bin/zsh
# prepare
g++ -std=c++11 -o a1 FenwickTree.cpp 
g++ -std=c++11 -o a2 SegmentTree.cpp 
g++ -std=c++11 -o a3 SegmentTree2.cpp

echo "FenwickTree measure= "
# for i in {0..1000}
# do
#     ./a1 "data/1e3/1e3_$i.txt" "output/fenwick/1e3/1e3_$i.out" "cerr/fenwick/1e3.txt"
# done
for i in {0..1000}
do
    ./a1 "data/1e5/1e5_$i.txt" "output/fenwick/1e5/1e5_$i.out" "cerr/fenwick/1e5.txt"
done
# echo ""
# echo "Fast Segment tree measure = "
# ./a2

# echo ""
# echo "Normal Segment tree measure= "
# ./a3
# echo ""
