# this is the script for creating the graphs for the Box & Whisker.

import matplotlib.pyplot as plt

alg1, alg2, alg3, alg4 = [], [], [], []

with open("time.txt", "r", encoding="utf-16") as file:  
    for line in file:
        line = line.strip()

        if "Algorithm 1" in line:
            numbers = line.split(":")[1].split(",")
            alg1 = [int(x.strip()) for x in numbers if x.strip()]

        elif "Algorithm 2" in line:
            numbers = line.split(":")[1].split(",")
            alg2 = [int(x.strip()) for x in numbers if x.strip()]

        elif "Algorithm 3" in line:
            numbers = line.split(":")[1].split(",")
            alg3 = [int(x.strip()) for x in numbers if x.strip()]

        elif "Algorithm 4" in line:
            numbers = line.split(":")[1].split(",")
            alg4 = [int(x.strip()) for x in numbers if x.strip()]


print("Alg1 size:", len(alg1))
print("Alg2 size:", len(alg2))
print("Alg3 size:", len(alg3))
print("Alg4 size:", len(alg4))

plt.figure(figsize=(8, 6))
plt.boxplot([alg1, alg2, alg3, alg4],
            labels=["Tixaios", "Megistis_Kalipsis", "Elaxistou_Megethous", "Basi_Piknotitas"])

plt.title("Execution Time Distribution (ns)")
plt.ylabel("Time (nanoseconds)")
plt.grid(True)

plt.show()