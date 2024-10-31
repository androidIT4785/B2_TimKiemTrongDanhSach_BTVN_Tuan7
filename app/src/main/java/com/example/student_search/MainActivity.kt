package com.example.student_search

import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.student_search.ui.theme.Student_searchTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout);

        val students = mutableListOf<Student>();
        students.add(Student("Ta Ngoc Tu", "20215503"))
        students.add(Student("Tran Van Khoi", "20210001"))
        students.add(Student("Nguyen Thi Mai", "20211002"))
        students.add(Student("Pham Minh Chau", "20212003"))
        students.add(Student("Le Hoang Tuan", "20213004"))
        students.add(Student("Hoang Thi Lan", "20214005"))
        students.add(Student("Do Duc Hieu", "20215006"))
        students.add(Student("Vo Thi Kim", "20216007"))
        students.add(Student("Nguyen Van Hau", "20217008"))
        students.add(Student("Ly Thi Nga", "20218009"))
        students.add(Student("Bui Ngoc Thinh", "20219010"))
        students.add(Student("Tran Quang Vinh", "20210011"))
        students.add(Student("Nguyen Thi Thao", "20211012"))
        students.add(Student("Pham Van Khanh", "20212013"))
        students.add(Student("Le Thi Linh", "20213014"))
        students.add(Student("Do Van Dat", "20214015"))
        students.add(Student("Hoang Thi Bao", "20215016"))
        students.add(Student("Ngo Thanh Tung", "20216017"))
        students.add(Student("Ly Kim Thu", "20217018"))
        students.add(Student("Nguyen Van Ky", "20218019"))
        students.add(Student("Tran Duc Thanh", "20219020"))
        students.add(Student("Pham Quoc Bao", "20210021"))
        students.add(Student("Vo Thi An", "20211022"))
        students.add(Student("Bui Huu Hung", "20212023"))
        students.add(Student("Ngo Ngoc Hai", "20213024"))
        students.add(Student("Le Van Phuc", "20214025"))
        students.add(Student("Nguyen Thi Dao", "20215026"))
        students.add(Student("Pham Thi Hoa", "20216027"))
        students.add(Student("Do Van Hoang", "20217028"))
        students.add(Student("Nguyen Thi Trang", "20218029"))
        students.add(Student("Hoang Anh Duc", "20219030"))
        students.add(Student("Ngo Thi Huong", "20210031"))
        students.add(Student("Le Huu Tai", "20211032"))
        students.add(Student("Bui Van Sang", "20212033"))
        students.add(Student("Ly Thi Yen", "20213034"))
        students.add(Student("Do Thi Ha", "20214035"))
        students.add(Student("Nguyen Van Phat", "20215036"))
        students.add(Student("Tran Thi Nhu", "20216037"))
        students.add(Student("Pham Quang Thanh", "20217038"))
        students.add(Student("Vo Van Loc", "20218039"))
        students.add(Student("Bui Thi Thuy", "20219040"))
        students.add(Student("Ly Van Khang", "20210041"))
        students.add(Student("Nguyen Thi Thanh", "20211042"))
        students.add(Student("Tran Van Minh", "20212043"))
        students.add(Student("Hoang Thi Thu", "20213044"))
        students.add(Student("Pham Huu Phuoc", "20214045"))
        students.add(Student("Le Thi Hang", "20215046"))
        students.add(Student("Ngo Van Tam", "20216047"))
        students.add(Student("Do Thanh Tuan", "20217048"))
        students.add(Student("Nguyen Hoai Nam", "20218049"))
        students.add(Student("Pham Ngoc Long", "20219050"))


        val adapter = StudentAdapter(students);

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view);
        recyclerView.layoutManager = LinearLayoutManager(this);
        recyclerView.adapter = adapter

        val input = findViewById<EditText>(R.id.input);
        input.doAfterTextChanged { text ->
            if (text != null && text.length > 2) {
                val filteredStudents = students.filter { student ->
                    student.hoTen.contains(text.toString(), ignoreCase = true) ||
                    student.mssv.contains(text.toString(), ignoreCase = true)
                }
                adapter.updateData(filteredStudents)
            } else {
                adapter.updateData(students)
            }
        }
    }
}