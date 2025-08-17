import styled from "styled-components";
import Card from "./components/Card/Card";
import { ITEMS } from "./api/items";

const Page = styled.main`
  max-width: 1280px;
  margin: 0 auto;
  padding: 24px 16px;
`;

const Header = styled.header`
  display: flex;
  justify-content: space-between;
  align-items: baseline;
  margin-bottom: 16px;
  h1 {
    margin: 0;
  }
  span {
    color: var(--muted);
    font-size: 14px;
  }
`;

const Grid = styled.section`
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(240px, 1fr));
  gap: 16px;
`;

export default function App() {
  return (
    <Page>
      <Header>
        <h1>희귀템 레이더</h1>
        <span>{ITEMS.length} items</span>
      </Header>

      <Grid>
        {ITEMS.map((it) => (
          <Card key={it.id} item={it} />
        ))}
      </Grid>
    </Page>
  );
}
