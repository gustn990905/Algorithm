class Solution {
    public int[] solution(int brown, int yellow) {
        int size = brown + yellow;

        for (int height = 1; height <= size; height++) {

            if (size % height == 0) {
                int width = size / height;

                if (width < height) {
                    continue;
                }

                if (width * 2 + height * 2 - 4 == brown) {
                    return new int[]{width, height};
                }
            }
        }

        return new int[]{};
    }
}