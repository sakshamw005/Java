class Robot {
public:
    int w, h;
    int x, y;
    int dir;
    int perim;
    bool moved;
    vector<string> dirs = {"East", "North", "West", "South"};
    Robot(int width, int height) {
        w = width;
        h = height;
        x = 0;
        y = 0;
        dir = 0;
        perim = 2 * (w + h) - 4;
        moved = false;
    }
    
    void step(int num) {
        moved = true;
        num %= perim;
        if (num == 0) num = perim;
        while (num > 0) {
            if (dir == 0) {
                int move = min(num, w - 1 - x);
                x += move;
                num -= move;
                if (num > 0) dir = 1;
            }
            else if (dir == 1) {
                int move = min(num, h - 1 - y);
                y += move;
                num -= move;
                if (num > 0) dir = 2;
            }
            else if (dir == 2) {
                int move = min(num, x);
                x -= move;
                num -= move;
                if (num > 0) dir = 3;
            }
            else { 
                int move = min(num, y);
                y -= move;
                num -= move;
                if (num > 0) dir = 0;
            }
        }
    }
    
    vector<int> getPos() {
        return {x, y};
    }
    
    string getDir() {
        if (!moved) return "East";
        return dirs[dir];
    }
};