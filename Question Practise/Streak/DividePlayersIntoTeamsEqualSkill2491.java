import java.util.Arrays;
public class DividePlayersIntoTeamsEqualSkill2491 {

    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int start = 0;
        int end = skill.length - 1;
        int sum = skill[start] + skill[end];
        long mul = 0;
        long totalsum = 0;
        while (start <= end) {
            if (skill[start] + skill[end] == sum) {
                mul = skill[start] * skill[end];
                totalsum += mul;
                start++;
                end--;
            } else {
                return -1;
            }

        }
        return totalsum;
    }
}