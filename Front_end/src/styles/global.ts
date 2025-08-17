import { createGlobalStyle } from 'styled-components';

export const GlobalStyle = createGlobalStyle`
  /* reset + 기본값 */
  *,*::before,*::after { box-sizing: border-box; }
  html, body, #root { height: 100%; margin: 0; padding: 0; }

  

  body{
    font-family: -apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Oxygen,Ubuntu,'Helvetica Neue',Arial,sans-serif;
    background: var(--bg);
    color: var(--text);
    line-height: 1.5;
  }
`;
