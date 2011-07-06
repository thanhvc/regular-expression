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
package org.exoplatform.common.regex.impl;

import org.exoplatform.common.regex.FiniteStateMachine;
import org.exoplatform.common.regex.InputTape;
import org.exoplatform.common.regex.State;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author <a href="hoang281283@gmail.com">Minh Hoang TO</a>
 * @date 7/6/11
 */
public abstract class CharacterFiniteStateMachine extends FiniteStateMachine<Character, Character>
{

   public CharacterFiniteStateMachine(State<Character> startState)
   {
      super(startState);
   }

   public boolean accept(final Reader reader) throws IOException
   {
      InputTape<Character> inputTape = new InputTape<Character>()
      {
         private int c = -1;

         @Override
         public boolean hasNext() throws IOException
         {
            c = reader.read();
            return c != -1;
         }

         @Override
         public Character next() throws IOException
         {
            if(c == -1)
            {
               throw new IllegalStateException();
            }
            return new Character((char)c);
         }
      };
      return super.accept(inputTape);
   }
}
