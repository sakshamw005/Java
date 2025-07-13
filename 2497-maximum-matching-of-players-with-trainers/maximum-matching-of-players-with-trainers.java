class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        
        Thread t1 = new Thread(() -> Arrays.sort(players));
        Thread t2 = new Thread(() -> Arrays.sort(trainers));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
        }
        int count = 0;
        int tracker = 0;
        int point = 0;

        while(tracker < trainers.length && point < players.length)
        {
            if(players[point] <= trainers[tracker])
            {
                count += 1;
                point += 1;
                tracker += 1;
            }
            else
            {
                tracker += 1;
            }
        }

        return count;
    }
}