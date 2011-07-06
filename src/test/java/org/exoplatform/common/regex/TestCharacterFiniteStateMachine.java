/*
 * Copyright (C) 2011 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.exoplatform.common.regex;

import junit.framework.TestCase;
import org.exoplatform.common.regex.impl.CharacterFiniteStateMachine;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * @author <a href="hoang281283@gmail.com">Minh Hoang TO</a>
 * @date 7/5/11
 */
public class TestCharacterFiniteStateMachine extends TestCase
{

   public void testRecognizeSimplePattern() throws IOException
   {
      State<Character> state_0, state_1, state_2, state_3, state_4, state_5, final_state;

      state_0 = State.getInstance("start", false);
      state_1 = State.getInstance("e", false);
      state_2 = State.getInstance("eX", false);
      state_3 = State.getInstance("eX*", false);
      state_4 = State.getInstance("eX*o", false);
      state_5 = State.getInstance("eX*oe", false);
      final_state = State.getInstance("eX*oer", true);

      state_0.connectTo('e', state_1);
      state_1.connectTo('X', state_2);

      for(char c = 'A'; c <= 'z'; c++)
      {
         if(c != 'e')
         {
            state_0.connectTo(c, state_0);
         }

         if(c != 'o')
         {
            state_2.connectTo(c, state_3);
            state_3.connectTo(c, state_3);
         }
      }

      state_2.connectTo('o', state_4);
      state_3.connectTo('o', state_4);

      state_4.connectTo('e', state_5);
      state_5.connectTo('r', final_state);

      CharacterFiniteStateMachine stateMachine = new CharacterFiniteStateMachine(state_0){
         @Override
         protected void makeTransition()
         {
            State<Character> currentState = getCurrentState();
            Character letter = getCommingInput();
            setCurrentState(currentState.findTargetState(letter));
         }
      };

      assertTrue(stateMachine.accept(new CharArrayReader("hoangisaneXoer!".toCharArray())));
      stateMachine.reset();
      assertTrue(stateMachine.accept(new CharArrayReader("hoangisaneXklmnoer!".toCharArray())));
      stateMachine.reset();
      assertFalse(stateMachine.accept(new CharArrayReader("hoangisaneXoreXoe!".toCharArray())));
      stateMachine.reset();
      assertFalse(stateMachine.accept(new CharArrayReader("hoangisaneX  oer".toCharArray())));
   }
}
