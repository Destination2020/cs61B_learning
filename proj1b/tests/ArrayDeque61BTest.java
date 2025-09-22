import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDeque61BTest {

//     @Test
//     @DisplayName("ArrayDeque61B has no fields besides backing array and primitives")
//     void noNonTrivialFields() {
//         List<Field> badFields = Reflection.getFields(ArrayDeque61B.class)
//                 .filter(f -> !(f.getType().isPrimitive() || f.getType().equals(Object[].class) || f.isSynthetic()))
//                 .toList();
//
//         assertWithMessage("Found fields that are not array or primitives").that(badFields).isEmpty();
//     }
    @Test
    @Order(1)
    @DisplayName("AddFirst and AddLast test at a test.")
    void addFirstAndAddLast() {
        ArrayDeque61B<String> test = new ArrayDeque61B<>();
        assertThat(test.isEmpty()).isTrue();
        test.addFirst("abcd");
        test.addLast("efgh");
        test.addFirst("mlj");
        test.addLast("ijkl");
        test.addLast("lytui");
        test.addLast("jhk");
        test.addLast("jet");
        test.addFirst("slgk");
        test.addFirst("vcz");
        assertThat(test.toList()).containsExactly("vcz", "slgk", "mlj", "abcd", "efgh", "ijkl", "lytui", "jhk", "jet");
        assertThat(test.size()).isEqualTo(9);
        assertThat(test.isEmpty()).isFalse();
        assertThat(test.removeFirst()).isEqualTo("vcz");
        assertThat(test.removeLast()).isEqualTo("jet");
        assertThat(test.size()).isEqualTo(7);
        assertThat(test.get(2)).isEqualTo("abcd");

    }

}
