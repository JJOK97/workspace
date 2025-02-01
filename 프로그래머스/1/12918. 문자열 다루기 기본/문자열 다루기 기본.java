
class Solution {
    public boolean solution(String s) {
        int size = s.length();

        if (size != 4 && size != 6) return false;

        return s.chars().allMatch(Character::isDigit);
    }
}
