package lc.q690.EmployeeImportance;
/*
 * 690. Employee Importance
 * Easy
 * You are given a data structure of employee information, which includes the employee's unique id, 
 * his importance value and his direct subordinates' id.

For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. 
They have importance value 15, 10 and 5, respectively. 
Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], 
and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, 
the relationship is not direct.

Now given the employee information of a company, and an employee id, 
you need to return the total importance value of this employee and all his subordinates.

Example 1:
Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
Output: 11
Explanation:
Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. 
They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
Note:
One employee has at most one direct leader and may have several subordinates.
The maximum number of employees won't exceed 2000.
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {

	public static void main(String[] args) {
		
	}

	public static int getImportance(List<Employee> employees, int id) 
    {	
		int res=0;
		return helper(employees,id,res);
	}
		
	private static int helper(List<Employee> e,int id,int imp)
	{
		for(int i =0;i<e.size();i++)
		{
			if(e.get(i).id == id)
			{
	            imp = e.get(i).importance;
				List<Integer> s = e.get(i).subordinates;
				if(s.size()==0)
					return e.get(i).importance;
				else
				{
					for(int j = 0;j<s.size();j++)
					{
						imp += helper(e,s.get(j),imp);
					}
				}
			}
		}
		return imp;	
	}
	
	
	public static int getImportance1(List<Employee> employees, int id)
	{
		Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return getImportanceHelper(map, id);
    }
    
    private static int getImportanceHelper(Map<Integer, Employee> map, int rootId) {
        Employee root = map.get(rootId);
        int total = root.importance;
        for (int subordinate : root.subordinates) {
            total += getImportanceHelper(map, subordinate);
        }
        return total;
	}
	
//    31.44%
    public int getImportance2(List<Employee> employees, int id) 
    {
        int res = 0;
        Map<Integer, Employee > eMap = new HashMap<Integer, Employee>();
        for(Employee e: employees)
        {
            eMap.put(e.id, e);
        }
        return helper(eMap,id,res);
    }
    
    private int helper(Map<Integer, Employee> map, int id, int res)
    {
        Employee root = map.get(id);
        res = root.importance;
        for(int sub:root.subordinates)
        {
            res += helper(map,sub,res);
        }
        return res;
    }
}
