package feature;

import static org.mockito.Mockito.verify;

import java.util.Collections;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cacib.operation.OperationEditor;

@RunWith(MockitoJUnitRunner.class)
public class OperationEditorTest {
	@Mock OperationEditor editor;
	@Test
	public void printEmptyTransactions(){
	
		editor.edit(Collections.emptyList());
		verify(editor).editOperationLine(OperationEditor.HEADER);
	}

	}

